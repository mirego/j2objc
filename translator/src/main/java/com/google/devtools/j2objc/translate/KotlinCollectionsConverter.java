// kotlin interop >>

package com.google.devtools.j2objc.translate;

import com.google.devtools.j2objc.ast.CompilationUnit;
import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.FunctionInvocation;
import com.google.devtools.j2objc.ast.MethodInvocation;
import com.google.devtools.j2objc.ast.UnitTreeVisitor;
import com.google.devtools.j2objc.types.FunctionElement;
import com.google.devtools.j2objc.util.KotlinUtil;
import com.google.devtools.j2objc.util.KotlinUtil.KotlinWrappedTypes;
import com.google.devtools.j2objc.util.TypeUtil;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.ExecutableElement;

/**
 * Adds support for converting Collections coming from Kotlin Native Code
 * to Java Collections for compatibility
 *
 * @author Mirego
 */
public class KotlinCollectionsConverter extends UnitTreeVisitor {

  private static final FunctionElement TO_IOS_OBJECT_ARRAY =
      new FunctionElement("toIOSObjectArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_IOS_BOOLEAN_ARRAY =
      new FunctionElement("toIOSBooleanArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_IOS_BYTE_ARRAY =
      new FunctionElement("toIOSByteArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_IOS_CHAR_ARRAY =
      new FunctionElement("toIOSCharArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_IOS_DOUBLE_ARRAY =
      new FunctionElement("toIOSDoubleArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_IOS_FLOAT_ARRAY =
      new FunctionElement("toIOSFloatArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_IOS_INT_ARRAY =
      new FunctionElement("toIOSIntArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_IOS_LONG_ARRAY =
      new FunctionElement("toIOSLongArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_IOS_SHORT_ARRAY =
      new FunctionElement("toIOSShortArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_KOTLIN_ARRAY =
      new FunctionElement("toKotlinArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_KOTLIN_BOOLEAN_ARRAY =
      new FunctionElement("toKotlinBooleanArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_KOTLIN_BYTE_ARRAY =
      new FunctionElement("toKotlinByteArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_KOTLIN_CHAR_ARRAY =
      new FunctionElement("toKotlinCharArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_KOTLIN_DOUBLE_ARRAY =
      new FunctionElement("toKotlinDoubleArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_KOTLIN_FLOAT_ARRAY =
      new FunctionElement("toKotlinFloatArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_KOTLIN_INT_ARRAY =
      new FunctionElement("toKotlinIntArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_KOTLIN_LONG_ARRAY =
      new FunctionElement("toKotlinLongArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  private static final FunctionElement TO_KOTLIN_SHORT_ARRAY =
      new FunctionElement("toKotlinShortArray", TypeUtil.ID_TYPE, null)
          .addParameters(TypeUtil.ID_TYPE);

  public KotlinCollectionsConverter(CompilationUnit unit) {
    super(unit);
  }

  @Override
  public void endVisit(MethodInvocation node) {
    ExecutableElement executableElement = node.getExecutableElement();
    if (KotlinUtil.isKotlinType(executableElement)) {
      convertInputParameters(node);
      convertReturnType(node, executableElement);

    }
    super.endVisit(node);
  }

  private void convertReturnType(MethodInvocation node, ExecutableElement executableElement) {
    KotlinWrappedTypes kotlinReturnType = KotlinUtil.getKotlinWrappedType(executableElement.getReturnType());
    if (kotlinReturnType != KotlinWrappedTypes.NONE) {
      addReturnValueTypeConversion(node, kotlinReturnType);
    }
  }

  private void convertInputParameters(MethodInvocation node) {
    List<Expression> arguments = node.getArguments();
    int numberOfArguments = arguments.size();
    if (numberOfArguments == 0) {
      return;
    }

    List<Expression> newArguments = new ArrayList<>(numberOfArguments);
    for (Expression currentArgument : arguments) {
      KotlinWrappedTypes kotlinType = KotlinUtil.getKotlinWrappedType(currentArgument.getTypeMirror());
      newArguments.add(addParamTypeConversion(currentArgument, kotlinType));
    }
    node.setArguments(newArguments);
  }

  private void addReturnValueTypeConversion(MethodInvocation node, KotlinWrappedTypes kotlinReturnType) {
    FunctionElement functionElement;
    switch (kotlinReturnType) {
      case ARRAY:
        functionElement = TO_IOS_OBJECT_ARRAY;
        break;
      case ARRAY_BOOLEAN:
        functionElement = TO_IOS_BOOLEAN_ARRAY;
        break;
      case ARRAY_BYTE:
        functionElement = TO_IOS_BYTE_ARRAY;
        break;
      case ARRAY_CHAR:
        functionElement = TO_IOS_CHAR_ARRAY;
        break;
      case ARRAY_DOUBLE:
        functionElement = TO_IOS_DOUBLE_ARRAY;
        break;
      case ARRAY_FLOAT:
        functionElement = TO_IOS_FLOAT_ARRAY;
        break;
      case ARRAY_INT:
        functionElement = TO_IOS_INT_ARRAY;
        break;
      case ARRAY_LONG:
        functionElement = TO_IOS_LONG_ARRAY;
        break;
      case ARRAY_SHORT:
        functionElement = TO_IOS_SHORT_ARRAY;
        break;
      case NONE:
      default:
        return;
    }

    FunctionInvocation typeConversionInvocation =
        new FunctionInvocation(functionElement, node.getTypeMirror());
    node.replaceWith(typeConversionInvocation);
    typeConversionInvocation.addArgument(node);
  }

  private Expression addParamTypeConversion(Expression originalArgument, KotlinWrappedTypes kotlinParamType) {
    FunctionElement functionElement;
    switch (kotlinParamType) {
      case ARRAY:
        functionElement = TO_KOTLIN_ARRAY;
        break;
      case ARRAY_BOOLEAN:
        functionElement = TO_KOTLIN_BOOLEAN_ARRAY;
        break;
      case ARRAY_BYTE:
        functionElement = TO_KOTLIN_BYTE_ARRAY;
        break;
      case ARRAY_CHAR:
        functionElement = TO_KOTLIN_CHAR_ARRAY;
        break;
      case ARRAY_DOUBLE:
        functionElement = TO_KOTLIN_DOUBLE_ARRAY;
        break;
      case ARRAY_FLOAT:
        functionElement = TO_KOTLIN_FLOAT_ARRAY;
        break;
      case ARRAY_INT:
        functionElement = TO_KOTLIN_INT_ARRAY;
        break;
      case ARRAY_LONG:
        functionElement = TO_KOTLIN_LONG_ARRAY;
        break;
      case ARRAY_SHORT:
        functionElement = TO_KOTLIN_SHORT_ARRAY;
        break;
      case NONE:
      default:
        return originalArgument;
    }

    FunctionInvocation typeConversionInvocation =
        new FunctionInvocation(functionElement, originalArgument.getTypeMirror());
    originalArgument.replaceWith(typeConversionInvocation);
    typeConversionInvocation.addArgument(originalArgument);
    return typeConversionInvocation;
  }
}

// kotlin interop <<
