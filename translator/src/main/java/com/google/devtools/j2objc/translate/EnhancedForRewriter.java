/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.j2objc.translate;

import com.google.devtools.j2objc.ast.Block;
import com.google.devtools.j2objc.ast.CompilationUnit;
import com.google.devtools.j2objc.ast.EnhancedForStatement;
import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.FieldAccess;
import com.google.devtools.j2objc.ast.InfixExpression;
import com.google.devtools.j2objc.ast.LabeledStatement;
import com.google.devtools.j2objc.ast.MethodInvocation;
import com.google.devtools.j2objc.ast.PostfixExpression;
import com.google.devtools.j2objc.ast.PrefixExpression;
import com.google.devtools.j2objc.ast.SimpleName;
import com.google.devtools.j2objc.ast.SingleVariableDeclaration;
import com.google.devtools.j2objc.ast.Statement;
import com.google.devtools.j2objc.ast.TreeUtil;
import com.google.devtools.j2objc.ast.UnitTreeVisitor;
import com.google.devtools.j2objc.ast.VariableDeclarationStatement;
import com.google.devtools.j2objc.ast.WhileStatement;
import com.google.devtools.j2objc.types.ExecutablePair;
import com.google.devtools.j2objc.types.GeneratedExecutableElement;
import com.google.devtools.j2objc.types.GeneratedTypeElement;
import com.google.devtools.j2objc.types.GeneratedVariableElement;
import com.google.devtools.j2objc.types.PointerType;
import com.google.devtools.j2objc.util.ElementUtil;
import com.google.devtools.j2objc.util.KotlinUtil;
import com.google.devtools.j2objc.util.TypeUtil;
import com.google.j2objc.annotations.AutoreleasePool;
import com.google.j2objc.annotations.LoopTranslation;
import com.google.j2objc.annotations.LoopTranslation.LoopStyle;

import java.util.List;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

/**
 * Rewrites Java enhanced for loops into appropriate C constructs.
 *
 * @author Keith Stanger
 */
public class EnhancedForRewriter extends UnitTreeVisitor {

  public EnhancedForRewriter(CompilationUnit unit) {
    super(unit);
  }

  @Override
  public void endVisit(EnhancedForStatement node) {
    Expression expression = node.getExpression();
    TypeMirror expressionType = expression.getTypeMirror();
    VariableElement loopVariable = node.getParameter().getVariableElement();

    if (ElementUtil.hasAnnotation(loopVariable, AutoreleasePool.class)) {
      makeBlock(node.getBody()).setHasAutoreleasePool(true);
    }

    // MIREGO kotlin interop >>
    if (KotlinUtil.isKotlinExpression(expression)){
      if (endVisitKotlin(node, expressionType)) {
        return;
      }
    }
    // MIREGO <<

    if (TypeUtil.isArray(expressionType)) {
      handleArrayIteration(node);
    } else if (emitJavaIteratorLoop(loopVariable)) {
      convertToJavaIteratorLoop(node);
    } else if (loopVariable.asType().getKind().isPrimitive()) {
      boxLoopVariable(node, expressionType, loopVariable);
    } else {
      VariableElement newLoopVariable = GeneratedVariableElement.mutableCopy(loopVariable)
          .setTypeQualifiers("__strong");
      node.getParameter().setVariableElement(newLoopVariable);
    }
  }

  private void handleArrayIteration(EnhancedForStatement node) {
    Expression expression = node.getExpression();
    ArrayType expressionType = (ArrayType) expression.getTypeMirror();
    VariableElement loopVariable = node.getParameter().getVariableElement();
    TypeMirror componentType = expressionType.getComponentType();
    TypeElement iosArrayType = typeUtil.getIosArray(componentType);
    TypeMirror bufferType = new PointerType(componentType);
    VariableElement arrayVariable = GeneratedVariableElement.newLocalVar(
        "a__", expressionType, null);
    VariableElement bufferVariable = GeneratedVariableElement.newLocalVar("b__", bufferType, null)
        .setTypeQualifiers("const*");
    VariableElement endVariable = GeneratedVariableElement.newLocalVar("e__", bufferType, null)
        .setTypeQualifiers("const*");
    VariableElement bufferField = GeneratedVariableElement.newField(
        "buffer", bufferType, iosArrayType)
        .addModifiers(Modifier.PUBLIC);
    VariableElement sizeField = GeneratedVariableElement.newField(
        "size", typeUtil.getInt(), iosArrayType)
        .addModifiers(Modifier.PUBLIC);

    VariableDeclarationStatement arrayDecl =
        new VariableDeclarationStatement(arrayVariable, TreeUtil.remove(expression));
    FieldAccess bufferAccess = new FieldAccess(bufferField, new SimpleName(arrayVariable));
    VariableDeclarationStatement bufferDecl =
        new VariableDeclarationStatement(bufferVariable, bufferAccess);
    InfixExpression endInit = new InfixExpression(
        bufferType, InfixExpression.Operator.PLUS, new SimpleName(bufferVariable),
        new FieldAccess(sizeField, new SimpleName(arrayVariable)));
    VariableDeclarationStatement endDecl = new VariableDeclarationStatement(endVariable, endInit);

    WhileStatement loop = new WhileStatement();
    loop.setExpression(new InfixExpression(
        typeUtil.getBoolean(), InfixExpression.Operator.LESS, new SimpleName(bufferVariable),
        new SimpleName(endVariable)));
    Block newLoopBody = makeBlock(TreeUtil.remove(node.getBody()));
    loop.setBody(newLoopBody);
    newLoopBody.addStatement(0, new VariableDeclarationStatement(
        loopVariable, new PrefixExpression(
            componentType, PrefixExpression.Operator.DEREFERENCE,
            new PostfixExpression(bufferVariable, PostfixExpression.Operator.INCREMENT))));

    Block block = new Block();
    List<Statement> stmts = block.getStatements();
    stmts.add(arrayDecl);
    stmts.add(bufferDecl);
    stmts.add(endDecl);
    stmts.add(loop);
    replaceLoop(node, block, loop);
  }

  private boolean emitJavaIteratorLoop(VariableElement loopVariable) {
    AnnotationMirror loopTranslation =
        ElementUtil.getAnnotation(loopVariable, LoopTranslation.class);
    if (loopTranslation == null) {
      return false;
    }
    Object style = ElementUtil.getAnnotationValue(loopTranslation, "value");
    if (style instanceof VariableElement
        && ElementUtil.getName((VariableElement) style).equals(LoopStyle.JAVA_ITERATOR.name())) {
      return true;
    }
    return false;
  }

  private void convertToJavaIteratorLoop(EnhancedForStatement node) {
    Expression expression = node.getExpression();
    TypeMirror expressionType = expression.getTypeMirror();
    VariableElement loopVariable = node.getParameter().getVariableElement();
    DeclaredType iterableType = typeUtil.findSupertype(expressionType, "java.lang.Iterable");
    ExecutablePair iteratorMethod = typeUtil.findMethod(iterableType, "iterator");
    DeclaredType iteratorType = (DeclaredType) iteratorMethod.type().getReturnType();
    ExecutablePair hasNextMethod = typeUtil.findMethod(iteratorType, "hasNext");
    ExecutablePair nextMethod = typeUtil.findMethod(iteratorType, "next");
    assert hasNextMethod != null && nextMethod != null;

    VariableElement iteratorVariable = GeneratedVariableElement.newLocalVar(
        "iter__", iteratorType, null);

    MethodInvocation iteratorInvocation =
        new MethodInvocation(iteratorMethod, TreeUtil.remove(expression));
    VariableDeclarationStatement iteratorDecl =
        new VariableDeclarationStatement(iteratorVariable, iteratorInvocation);
    MethodInvocation hasNextInvocation =
        new MethodInvocation(hasNextMethod, new SimpleName(iteratorVariable));
    MethodInvocation nextInvocation =
        new MethodInvocation(nextMethod, new SimpleName(iteratorVariable));

    Block newLoopBody = makeBlock(TreeUtil.remove(node.getBody()));
    newLoopBody.addStatement(
        0, new VariableDeclarationStatement(loopVariable, nextInvocation));

    WhileStatement whileLoop = new WhileStatement();
    whileLoop.setExpression(hasNextInvocation);
    whileLoop.setBody(newLoopBody);

    Block block = new Block();
    List<Statement> stmts = block.getStatements();
    stmts.add(iteratorDecl);
    stmts.add(whileLoop);
    replaceLoop(node, block, whileLoop);
  }

  private void replaceLoop(EnhancedForStatement oldLoop, Statement replacement, Statement newLoop) {
    if (oldLoop.getParent() instanceof LabeledStatement) {
      LabeledStatement labeledStmt = (LabeledStatement) oldLoop.getParent();
      labeledStmt.replaceWith(replacement);
      newLoop.replaceWith(labeledStmt);
      labeledStmt.setBody(newLoop);
    } else {
      oldLoop.replaceWith(replacement);
    }
  }

  private void boxLoopVariable(
      EnhancedForStatement node, TypeMirror expressionType, VariableElement loopVariable) {
    DeclaredType iterableType = typeUtil.findSupertype(expressionType, "java.lang.Iterable");
    List<? extends TypeMirror> typeArgs = iterableType.getTypeArguments();
    assert typeArgs.size() == 1 && typeUtil.isBoxedType(typeArgs.get(0));
    VariableElement boxVariable = GeneratedVariableElement.newLocalVar(
        "boxed__", typeArgs.get(0), null);
    node.setParameter(new SingleVariableDeclaration(boxVariable));
    makeBlock(node.getBody()).addStatement(
        0, new VariableDeclarationStatement(loopVariable, new SimpleName(boxVariable)));
  }

  private Block makeBlock(Statement stmt) {
    if (stmt instanceof Block) {
      return (Block) stmt;
    }
    Block block = new Block();
    if (stmt.getParent() != null) {
      stmt.replaceWith(block);
    }
    block.addStatement(stmt);
    return block;
  }

  // MIREGO kotlin interop >>

  private boolean endVisitKotlin(EnhancedForStatement node, TypeMirror expressionType) {
    if (TypeUtil.isArray(expressionType)) {
      convertToKotlinLoopIterator(node);
      return true;
    }

    return false;
  }

  /*

      CommonKotlinArray *array = CommonSimpleEnum.values;
    id<CommonKotlinIterator> iterator = [array iterator];

    while([iterator hasNext])
    {
       CommonSimpleEnum *next = [iterator next];
        JreStrAppend(&combinedEnumNames, "$", [((CommonSimpleEnum *) nil_chk(next)) name]);
    }
   */

  private void convertToKotlinLoopIterator(EnhancedForStatement node) {
    Expression expression = node.getExpression();
    Element elementFromExpression = KotlinUtil.getElementFromExpression(expression);

    if (!(elementFromExpression instanceof ExecutableElement)) {
      throw new RuntimeException("Expecting expression element to be instance of ExecutableElement but was : "
              + elementFromExpression.getClass().getSimpleName());
    }

    // create a local variable to store the array for example getting values array from an enum.
    // example code : CommonKotlinArray *_array = CommonSimpleEnum.values;
    GeneratedTypeElement commonKotlinArray = KotlinUtil.getKotlinArrayTypeElement();
    String arraySourceElementName = KotlinUtil.getKotlinElementName((ExecutableElement)elementFromExpression, nameTable);
    SimpleName arraySourceElementSimpleName = new SimpleName(arraySourceElementName);
    SimpleName arraySimpleName = new SimpleName("_array");

    GeneratedTypeElement enumType = GeneratedTypeElement.newIosClass(arraySourceElementName, null, null);
    GeneratedVariableElement kotlinArrayVariable = GeneratedVariableElement
            .newLocalVar(arraySimpleName.getIdentifier(), commonKotlinArray.asType(), commonKotlinArray);
    GeneratedExecutableElement getArrayElement = GeneratedExecutableElement
            .newMethodWithSelector(elementFromExpression.getSimpleName().toString(), commonKotlinArray.asType(),
                    commonKotlinArray);

    ExecutablePair getArrayPair = new ExecutablePair(getArrayElement);
    MethodInvocation arrayInvocation =
            new MethodInvocation(getArrayPair, arraySourceElementSimpleName);

    VariableDeclarationStatement kotlinArrayDecl =
            new VariableDeclarationStatement(kotlinArrayVariable, arrayInvocation);

    // create a local variable to store the array iterator
    // example code : id _iterator = [array iterator];

    GeneratedTypeElement commonKotlinIterator = KotlinUtil.getKotlinIteratorTypeElement();
    SimpleName iteratorSimpleName = new SimpleName("_iterator");

    GeneratedVariableElement kotlinArrayIterator = GeneratedVariableElement
            .newLocalVar(iteratorSimpleName.getIdentifier(), TypeUtil.ID_TYPE, commonKotlinIterator);
    GeneratedExecutableElement getIteratorElement = GeneratedExecutableElement
            .newMethodWithSelector("iterator", kotlinArrayIterator.asType(),
                    commonKotlinArray);
    ExecutablePair getIteratorPair = new ExecutablePair(getIteratorElement);

    MethodInvocation iteratorInvocation =
            new MethodInvocation(getIteratorPair, arraySimpleName.copy());

    VariableDeclarationStatement kotlinArrayIteratorDecl =
            new VariableDeclarationStatement(kotlinArrayIterator, iteratorInvocation);

    // create the method invocation used as a condition for the while loop that runs through the array
    // example code : [_iterator hasNext]
    GeneratedExecutableElement hasNextKotlinIterator = GeneratedExecutableElement
            .newMethodWithSelector("hasNext", typeUtil.getBoolean(),
                    commonKotlinIterator);
    ExecutablePair hasNextPair = new ExecutablePair(hasNextKotlinIterator);
    MethodInvocation hasNextIteratorInvocation =
            new MethodInvocation(hasNextPair, iteratorSimpleName);

    // create the method invocation used in the while loop that fetches the next element to process
    // example code : CommonSimpleEnum *value = [_iterator next];
    GeneratedExecutableElement nextKotlinIterator = GeneratedExecutableElement
            .newMethodWithSelector("next", enumType.asType(),
                    commonKotlinIterator);
    ExecutablePair nextPair = new ExecutablePair(nextKotlinIterator);
    MethodInvocation nextIteratorInvocation =
            new MethodInvocation(nextPair, iteratorSimpleName.copy());

    TreeUtil.remove(expression);

    VariableElement loopVariable = node.getParameter().getVariableElement();
    Block newLoopBody = makeBlock(TreeUtil.remove(node.getBody()));
    newLoopBody.addStatement(
            0, new VariableDeclarationStatement(loopVariable, nextIteratorInvocation));

    WhileStatement whileLoop = new WhileStatement();
    whileLoop.setExpression(hasNextIteratorInvocation);
    whileLoop.setBody(newLoopBody);

    Block block = new Block();
    List<Statement> stmts = block.getStatements();
    stmts.add(kotlinArrayDecl);
    stmts.add(kotlinArrayIteratorDecl);
    stmts.add(whileLoop);
    replaceLoop(node, block, whileLoop);
  }

  // MIREGO <<
}
