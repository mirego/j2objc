// kotlin interop >>

package com.google.devtools.j2objc.util;

import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.FunctionInvocation;
import com.google.devtools.j2objc.ast.MethodInvocation;
import com.google.devtools.j2objc.types.FunctionElement;

import java.util.List;

import javax.annotation.Nullable;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import static java.util.stream.Collectors.toList;

public class NativeObjectsUtil {

  public static void translateBridgedTypeInMethodInvocation(MethodInvocation node, TypeUtil typeUtil) {
    if (node.getExpression() == null || node.getExpression().getTypeMirror() == null) {
      return;
    }
    if (KotlinUtil.isKotlinType(node.getExpression().getTypeMirror())) {
      // Check if the method being called is getClass
      if (node.getExecutableElement().getSimpleName().toString().equals("getClass")) {
        // replace with inline method
        FunctionElement j2objcGetClassElement =
          new FunctionElement("kotlinGetClass", TypeUtil.ID_TYPE, null);
        FunctionInvocation other = new FunctionInvocation(j2objcGetClassElement, TypeUtil.ID_TYPE);
        other.addArgument(node.getExpression().copy());
        node.replaceWith(other);
        return;
      }

      // Convert collection arguments to proper type if needed
      List<Expression> convertedParameters = node.getArguments().stream().map(argument -> {
        if (NativeObjectsUtil.isNativelyBridgedObject(argument.getTypeMirror(), typeUtil)) {
          String functionName;
          if (typeUtil.getJavaMap().equals(TypeUtil.asTypeElement(argument.getTypeMirror()))) {
            functionName = "javaMapToKotlinMutableDictionary";
          } else if (typeUtil.getJavaSet().equals(TypeUtil.asTypeElement(argument.getTypeMirror()))) {
            functionName = "javaSetToKotlinMutableSet";
          } else {
            functionName = "javaCollectionToNSMutableArray";
          }

          FunctionElement j2objcCreateSetElement =
            new FunctionElement(functionName, TypeUtil.ID_TYPE, null);
          FunctionInvocation createSetFunction =
            new FunctionInvocation(j2objcCreateSetElement, TypeUtil.ID_TYPE);
          createSetFunction.addArgument(argument.copy());
          return createSetFunction;
        } else {
          return argument.copy();
        }
      }).collect(toList());
      node.setArguments(convertedParameters);
    }
  }

  private static boolean isNativelyBridgedObject(TypeMirror typeMirror, TypeUtil typeUtil) {
    return isNativelyBridgedObject(TypeUtil.asTypeElement(typeMirror), typeUtil);
  }

  private static boolean isNativelyBridgedObject(@Nullable TypeElement type, TypeUtil typeUtil) {
    if (type == null) {
      return false;
    }

    return isConvertibleCollection(type, typeUtil)
      ||  isConvertibleList(type, typeUtil)
      || isConvertibleSet(type, typeUtil)
      || isConvertibleMap(type, typeUtil);
  }

  private static boolean isConvertibleCollection(TypeElement type, TypeUtil typeUtil) {
    return typeUtil.getJavaCollection().equals(type);
  }

  private static boolean isConvertibleList(TypeElement type, TypeUtil typeUtil) {
    return typeUtil.getJavaList().equals(type);
  }

  private static boolean isConvertibleSet(TypeElement type, TypeUtil typeUtil) {
    return typeUtil.getJavaSet().equals(type);
  }

  private static boolean isConvertibleMap(TypeElement type, TypeUtil typeUtil) {
    return typeUtil.getJavaMap().equals(type);
  }
}

// kotlin interop <<
