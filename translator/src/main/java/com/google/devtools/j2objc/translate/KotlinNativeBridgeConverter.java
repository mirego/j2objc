// kotlin interop >>

package com.google.devtools.j2objc.translate;

import com.google.devtools.j2objc.ast.CompilationUnit;
import com.google.devtools.j2objc.ast.MethodInvocation;
import com.google.devtools.j2objc.ast.UnitTreeVisitor;
import com.google.devtools.j2objc.util.NativeObjectsUtil;

public class KotlinNativeBridgeConverter extends UnitTreeVisitor {

  public KotlinNativeBridgeConverter(CompilationUnit unit) {
    super(unit);
  }

  @Override
  public void endVisit(MethodInvocation node) {
    NativeObjectsUtil.translateBridgedTypeInMethodInvocation(node, typeUtil);
  }
}

// kotlin interop <<
