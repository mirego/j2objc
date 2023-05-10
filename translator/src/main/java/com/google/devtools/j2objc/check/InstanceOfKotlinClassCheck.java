// kotlin interop >>

package com.google.devtools.j2objc.check;

import com.google.devtools.j2objc.ast.CompilationUnit;
import com.google.devtools.j2objc.ast.InstanceofExpression;
import com.google.devtools.j2objc.ast.UnitTreeVisitor;
import com.google.devtools.j2objc.util.ErrorUtil;
import com.google.devtools.j2objc.util.KotlinUtil;
import com.google.devtools.j2objc.util.TypeUtil;

import javax.lang.model.element.TypeElement;

public class InstanceOfKotlinClassCheck extends UnitTreeVisitor {

    public InstanceOfKotlinClassCheck(CompilationUnit unit) {
        super(unit);
    }

    @Override
    public boolean visit(InstanceofExpression node) {

        TypeElement rightType = TypeUtil.asTypeElement(node.getRightOperand().getTypeMirror());

        if (rightType != null && KotlinUtil.isKotlinType(rightType)) {
            ErrorUtil.error(String.format("%s : Using instanceOf operator on a Kotlin class type (%s) is not supported.", unit.getSourceFilePath(), rightType.getSimpleName().toString()));
        }

        return super.visit(node);
    }
}

// kotlin interop <<
