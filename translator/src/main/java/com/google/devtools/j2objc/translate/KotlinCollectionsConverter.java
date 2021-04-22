package com.google.devtools.j2objc.translate;

import com.google.devtools.j2objc.ast.Assignment;
import com.google.devtools.j2objc.ast.CompilationUnit;
import com.google.devtools.j2objc.ast.FunctionInvocation;
import com.google.devtools.j2objc.ast.MethodInvocation;
import com.google.devtools.j2objc.ast.UnitTreeVisitor;
import com.google.devtools.j2objc.types.FunctionElement;
import com.google.devtools.j2objc.util.ElementUtil;
import com.google.devtools.j2objc.util.KotlinUtil;
import com.google.devtools.j2objc.util.KotlinUtil.KotlinCollectionType;
import com.google.devtools.j2objc.util.TypeUtil;

import javax.lang.model.element.ExecutableElement;

/**
 * Adds support for convertin Collections comming for Kotlin Native Code
 * to Java Collections to ensure compatibility
 *
 * @author Mirego 2021
 */

public class KotlinCollectionsConverter extends UnitTreeVisitor {

    private static final FunctionElement TO_JAVA_LIST =
            new FunctionElement("toJavaUtilList", TypeUtil.ID_TYPE, null)
                    .addParameters(TypeUtil.ID_TYPE);

    public KotlinCollectionsConverter(CompilationUnit unit) {
        super(unit);
    }

    @Override
    public void endVisit(Assignment node) {
        super.endVisit(node);
    }

    @Override
    public void endVisit(MethodInvocation node) {
        ExecutableElement executableElement = node.getExecutableElement();
        if (ElementUtil.isKotlinType(executableElement)) {
            KotlinCollectionType kotlinReturnType = KotlinUtil.getKotlinReturnType(executableElement.getReturnType());
            if (kotlinReturnType != KotlinCollectionType.NONE) {
                addTypeConversion(node, kotlinReturnType);
                return;
            }
        }
        super.endVisit(node);
    }

    private void addTypeConversion(MethodInvocation node, KotlinCollectionType kotlinReturnType) {
        FunctionElement functionElement = null;
        switch (kotlinReturnType) {

            case LIST:
                functionElement = TO_JAVA_LIST;
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

}
