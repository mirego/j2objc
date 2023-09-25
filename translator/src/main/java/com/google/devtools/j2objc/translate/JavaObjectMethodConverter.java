// kotlin interop >>

package com.google.devtools.j2objc.translate;

import com.google.devtools.j2objc.ast.CastExpression;
import com.google.devtools.j2objc.ast.CompilationUnit;
import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.InstanceofExpression;
import com.google.devtools.j2objc.ast.MethodInvocation;
import com.google.devtools.j2objc.ast.UnitTreeVisitor;
import com.google.devtools.j2objc.util.KotlinUtil;
import com.google.devtools.j2objc.util.TypeUtil;

public class JavaObjectMethodConverter extends UnitTreeVisitor {

  public JavaObjectMethodConverter(CompilationUnit unit) {
    super(unit);
  }

  @Override
  public void endVisit(MethodInvocation node) {
    Expression expression = node.getExpression();
    if (expression == null
        || !KotlinUtil.isKotlinType(expression.getTypeMirror())
        || !TypeUtil.isInterface(expression.getTypeMirror())) {
      return;
    }

    boolean isToStringMethod = node.getExecutableElement().getSimpleName().toString().equals("toString") &&
        node.getExecutableElement().getParameters().isEmpty();

    if (isToStringMethod) {
      CastExpression castedExpression = new CastExpression(TypeUtil.ID_TYPE, node.getExpression().copy());
      node.setExpression(castedExpression);
    }
  }

  @Override
  public void endVisit(InstanceofExpression node) {
    Expression leftOperand = node.getLeftOperand();

    // Must cast to `(id)` when testing for `instanceof` on a Kotlin interface
    // because NSObject is not in the hierarchy
    if (KotlinUtil.isKotlinType(leftOperand.getTypeMirror()) && TypeUtil.isInterface(leftOperand.getTypeMirror())) {
      CastExpression castedLeftOperand = new CastExpression(TypeUtil.ID_TYPE, leftOperand.copy());
      node.setLeftOperand(castedLeftOperand);
    }
  }
}

// kotlin interop <<
