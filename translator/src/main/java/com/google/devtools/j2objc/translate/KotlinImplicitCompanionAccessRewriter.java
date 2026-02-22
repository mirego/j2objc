// kotlin interop >>

package com.google.devtools.j2objc.translate;

import com.google.devtools.j2objc.ast.Assignment;
import com.google.devtools.j2objc.ast.ClassInstanceCreation;
import com.google.devtools.j2objc.ast.CompilationUnit;
import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.FieldAccess;
import com.google.devtools.j2objc.ast.MethodInvocation;
import com.google.devtools.j2objc.ast.PropertyAccess;
import com.google.devtools.j2objc.ast.SimpleName;
import com.google.devtools.j2objc.ast.TreeUtil;
import com.google.devtools.j2objc.ast.UnitTreeVisitor;
import com.google.devtools.j2objc.types.ExecutablePair;
import com.google.devtools.j2objc.types.GeneratedExecutableElement;
import com.google.devtools.j2objc.util.ElementUtil;
import com.google.devtools.j2objc.util.KotlinUtil;
import com.google.devtools.j2objc.util.NameTable;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

import kotlin.metadata.KmDeclarationContainer;
import kotlin.metadata.KmFunction;
import kotlin.metadata.KmProperty;

/**
 * Add missing references to "Companion" object when a field is annotated
 * with @JvmField or a method is annotated with @JvmStatic
 */
public class KotlinImplicitCompanionAccessRewriter extends UnitTreeVisitor {

  public KotlinImplicitCompanionAccessRewriter(CompilationUnit unit) {
    super(unit);
  }

  @Override
  public void endVisit(FieldAccess node) {
    if (KotlinUtil.isKotlinType(node.getVariableElement())) {
      endVisitFieldAccess(node);
    }
  }

  @Override
  public void endVisit(MethodInvocation node) {
    ExecutableElement method = node.getExecutableElement();

    if (KotlinUtil.isKotlinType(method)) {
      endVisitMethodInvocation(node, method);
    }
  }

  @Override
  public void endVisit(ClassInstanceCreation node) {
    ExecutableElement element = node.getExecutableElement();

    if (KotlinUtil.isKotlinType(element)) {
      endVisitClassInstanceCreation(node, element);
    }
  }

  private void endVisitFieldAccess(FieldAccess node) {
    VariableElement variableElement = node.getVariableElement();
    KmDeclarationContainer declarationContainer = KotlinUtil.getElementKotlinDeclarationContainer(variableElement);
    KmProperty property = KotlinUtil.matchVariableNameWithKotlin(variableElement, declarationContainer);
    Optional<? extends Element> companion = findCompanionObjectOrObject(variableElement);

    if (property == null && ElementUtil.isStatic(variableElement) && companion.isPresent()) {
      KmDeclarationContainer companionDeclarationContainer = KotlinUtil.getElementKotlinDeclarationContainer(companion.get());
      property = KotlinUtil.matchVariableNameWithKotlin(variableElement, companionDeclarationContainer);
      if (property != null) {
        // The property has been found on the companion object. Add the
        // reference to the Companion object
        String companionObjectName = NameTable.uncapitalize(companion.get().getSimpleName().toString());

        TypeElement rootElement = ElementUtil.getDeclaringClass(node.getVariableElement());
        Element companionElement = rootElement.getEnclosedElements().get(0);
        TypeMirror typeMirror = companionElement.asType();

        GeneratedExecutableElement getInstanceElement = GeneratedExecutableElement
            .newMethodWithSelector(companionObjectName, typeMirror, companionElement);

        ExecutablePair getInstancePair = new ExecutablePair(getInstanceElement);

        String fullName = nameTable.getFullName(rootElement);

        SimpleName methodInvocationExpression = new SimpleName(fullName + NameTable.capitalize(companionObjectName));
        methodInvocationExpression.setTypeMirror(companionElement.asType());
        MethodInvocation a = new MethodInvocation(getInstancePair, methodInvocationExpression);

        node.setExpression(a);
      }
    }
  }

  private void endVisitMethodInvocation(MethodInvocation node, ExecutableElement element) {
    KmDeclarationContainer declarationContainer = KotlinUtil.getElementKotlinDeclarationContainer(element);
    KmFunction kotlinFunction = KotlinUtil.matchFunctionNameWithKotlin(element, declarationContainer);
    Optional<? extends Element> companion = findCompanionObjectOrObject(element);

    // if we did not find the function directly on the container, check is this class has a companion and look there
    Element actualContainingElement = null;
    if (kotlinFunction == null && ElementUtil.isStatic(element) && companion.isPresent()) {
      KmDeclarationContainer companionDeclarationContainer = KotlinUtil.getElementKotlinDeclarationContainer(companion.get());
      kotlinFunction = KotlinUtil.matchFunctionNameWithKotlin(element, companionDeclarationContainer);
      if (kotlinFunction != null) {
        declarationContainer = companionDeclarationContainer;
        actualContainingElement = companion.get();
      }
    }

    KmProperty propertyAccessor = null;
    if (kotlinFunction == null) {
      propertyAccessor = KotlinUtil.getKotlinPropertyAccessor(element, declarationContainer);
    }

    // Enum property access or function calls do not happen on the Enum but on an instance
    // so we don't need any special handling
    if (kotlinFunction == null && propertyAccessor == null
        && (KotlinUtil.isKotlinEnum(declarationContainer) || KotlinUtil.isKotlinEnumSpecialMethodCall(element))) {
      Expression expression = convertEnumExpression(element);
      node.setExpression(expression);
      return;
    }

    if (KotlinUtil.isKotlinCompanionObjectOrObject(declarationContainer)) {
      convertCompanionObjectOrObjectExpressionForMethodInvocation(node, element, actualContainingElement);
    }

    if (propertyAccessor != null) {
      convertPropertyAccessExpression(node, element, propertyAccessor);
    }
  }

  private Optional<? extends Element> findCompanionObjectOrObject(Element element) {
    List<? extends Element> enclosedElements = element.getEnclosingElement().getEnclosedElements();
    // Check in the enclosed elements what we have for the companion
    return enclosedElements.stream().filter(KotlinUtil::isElementKotlinCompanionObjectOrObject).findFirst();
  }

  private void endVisitClassInstanceCreation(ClassInstanceCreation node, ExecutableElement element) {
    String fullName = nameTable.getFullFunctionName(element);

    String className = node.getExecutableElement().getEnclosingElement().getSimpleName().toString();
    int idx = fullName.indexOf(className);
    fullName = fullName.substring(0, idx + className.length());

    GeneratedExecutableElement classElement = GeneratedExecutableElement
        .newMethodWithSelector(fullName, node.getTypeMirror(), ElementUtil.getDeclaringClass(element));

    GeneratedExecutableElement allocElement = GeneratedExecutableElement
        .newMethodWithSelector("alloc", node.getExecutableType().getReturnType(),
            ElementUtil.getDeclaringClass(element));
    ExecutablePair allocPair = new ExecutablePair(allocElement, node.getExecutableType());

    MethodInvocation allocMethod = new MethodInvocation(allocPair, new SimpleName(classElement));

    MethodInvocation initMethod = new MethodInvocation(node.getExecutablePair(), allocMethod);
    TreeUtil.moveList(node.getCaptureArgs(), initMethod.getArguments());
    TreeUtil.moveList(node.getArguments(), initMethod.getArguments());

    if (options.useARC()) {
      node.replaceWith(initMethod);

    } else {
      GeneratedExecutableElement autoreleaseElement = GeneratedExecutableElement
          .newMethodWithSelector("autorelease", node.getExecutableType().getReturnType(),
              ElementUtil.getDeclaringClass(element));
      ExecutablePair autoreleasePair = new ExecutablePair(autoreleaseElement, node.getExecutableType());
      MethodInvocation autoreleaseMethod = new MethodInvocation(autoreleasePair, initMethod);

      node.replaceWith(autoreleaseMethod);
    }
  }

  private void convertPropertyAccessExpression(MethodInvocation node, ExecutableElement element, KmProperty getterOrSetterProperty) {
    SimpleName simpleName = new SimpleName(getterOrSetterProperty.getName());
    simpleName.setTypeMirror(element.getReturnType());
    PropertyAccess propertyAccess = new PropertyAccess(node.getExpression(), simpleName);

    if (KotlinUtil.isKotlinGetter(element)) {
      node.replaceWith(propertyAccess);
    } else {
      List<Expression> arguments = node.getArguments();
      if (arguments.size() != 1) {
        throw new RuntimeException("Kotlin interop assumes 1 argument when handling auto generated setter ... " + node);
      }
      Assignment assignment = new Assignment(propertyAccess, arguments.get(0).copy());
      node.replaceWith(assignment);
    }
  }

  private void convertCompanionObjectOrObjectExpressionForMethodInvocation(MethodInvocation methodInvocation, ExecutableElement element, @Nullable Element actualContainingElement) {
    String executableElementName = KotlinUtil.getKotlinElementName(element, nameTable);
    TypeMirror typeMirror = ElementUtil.getDeclaringClass(element).asType();
    Expression nodeExpression = methodInvocation.getExpression();

    String instanceSelector;
    SimpleName executableExpression;
    if (ElementUtil.isStatic(element)) {
      if (actualContainingElement != null) {
        instanceSelector = "companion";
      } else if (nodeExpression != null) {
        instanceSelector = NameTable.uncapitalize(nodeExpression.toString());
      } else {
        instanceSelector = "shared";
      }
      executableExpression = new SimpleName(executableElementName);
    } else if (KotlinUtil.isKotlinObjectWithoutJvmStaticAnnotation(nodeExpression)) {
      FieldAccess fieldAccess = (FieldAccess) nodeExpression;
      instanceSelector = NameTable.uncapitalize(fieldAccess.getExpression().toString());
      executableExpression = new SimpleName(executableElementName);
    } else {
      instanceSelector = getCompanionObjectOrObjectInstanceSelector(nodeExpression.toString());
      executableExpression = new SimpleName(executableElementName + NameTable.capitalize(instanceSelector));
    }
    executableExpression.setTypeMirror(typeMirror);

    if (instanceSelector != null) {
      GeneratedExecutableElement getInstanceElement = GeneratedExecutableElement
          .newMethodWithSelector(instanceSelector, typeMirror,
              ElementUtil.getDeclaringClass(element));

      ExecutablePair getInstancePair = new ExecutablePair(getInstanceElement);
      MethodInvocation newMethodInvocation = new MethodInvocation(getInstancePair, executableExpression);
      methodInvocation.setExpression(newMethodInvocation);
    } else {
      methodInvocation.setExpression(executableExpression);
    }
  }

  private String getCompanionObjectOrObjectInstanceSelector(String nodeExpression) {
    String[] nodeExpressionSplit = nodeExpression.split("\\.");

    if (nodeExpressionSplit.length < 2 || nodeExpressionSplit.length > 3) {
      throw new RuntimeException("Expected a instance selector with the pattern Class.Companion or Class.Object.INSTANCE: " + nodeExpression);
    }
    return NameTable.uncapitalize(nodeExpressionSplit[1]);
  }

  private Expression convertEnumExpression(ExecutableElement element) {
    String fullName = KotlinUtil.getKotlinElementName(element, nameTable);
    TypeMirror typeMirror = ElementUtil.getDeclaringClass(element).asType();
    return new SimpleName(fullName)
        .setTypeMirror(typeMirror);
  }

}
// kotlin interop <<
