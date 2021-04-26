package com.google.devtools.j2objc.translate;

import com.google.devtools.j2objc.ast.CompilationUnit;
import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.ExpressionMethodReference;
import com.google.devtools.j2objc.ast.ExpressionStatement;
import com.google.devtools.j2objc.ast.FunctionInvocation;
import com.google.devtools.j2objc.ast.MethodInvocation;
import com.google.devtools.j2objc.ast.ParameterizedType;
import com.google.devtools.j2objc.ast.UnitTreeVisitor;
import com.google.devtools.j2objc.types.FunctionElement;
import com.google.devtools.j2objc.types.GeneratedExecutableElement;
import com.google.devtools.j2objc.types.GeneratedVariableElement;
import com.google.devtools.j2objc.util.ElementUtil;
import com.google.devtools.j2objc.util.KotlinUtil;
import com.google.devtools.j2objc.util.KotlinUtil.KotlinWrappedTypes;
import com.google.devtools.j2objc.util.TypeUtil;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;

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

    private static final FunctionElement TO_IOS_OBJECT_ARRAY =
            new FunctionElement("toIOSObjectArray", TypeUtil.ID_TYPE, null)
                    .addParameters(TypeUtil.ID_TYPE);

    private static final FunctionElement TO_KOTLIN_ARRAY=
            new FunctionElement("toKotlinArray", TypeUtil.ID_TYPE, null)
                    .addParameters(TypeUtil.ID_TYPE);

    public KotlinCollectionsConverter(CompilationUnit unit) {
        super(unit);
    }

    @Override
    public void endVisit(MethodInvocation node) {
        ExecutableElement executableElement = node.getExecutableElement();
        if (ElementUtil.isKotlinType(executableElement)) {
            convertInputParameters(node, executableElement);
            convertReturnType(node, executableElement);

        }
        super.endVisit(node);
    }

    private void convertReturnType(MethodInvocation node, ExecutableElement executableElement) {
        KotlinWrappedTypes kotlinReturnType = KotlinUtil.getKotlinType(executableElement.getReturnType());
        if (kotlinReturnType != KotlinWrappedTypes.NONE) {
            addReturnValueTypeConversion(node, kotlinReturnType);
        }
    }

    private void convertInputParameters(MethodInvocation node, ExecutableElement executableElement) {
        List<Expression> arguments = node.getArguments();
        int numberOfArguments = arguments.size();
        if (numberOfArguments == 0) {
            return;
        }

        List<Expression> newArguments = new ArrayList<>(numberOfArguments);
        for (Expression currentArgument : arguments) {
            KotlinWrappedTypes kotlinType = KotlinUtil.getKotlinType(currentArgument.getTypeMirror());
            newArguments.add(addParamTypeConversion(currentArgument, kotlinType));
        }
        node.setArguments(newArguments);
    }

    @Override
    public void endVisit(ExpressionMethodReference node) {
        super.endVisit(node);
    }

    @Override
    public void endVisit(ExpressionStatement node) {
        super.endVisit(node);
    }

    @Override
    public void endVisit(ParameterizedType node) {
        super.endVisit(node);
    }

    private void addReturnValueTypeConversion(MethodInvocation node, KotlinWrappedTypes kotlinReturnType) {
        FunctionElement functionElement;
        switch (kotlinReturnType) {
            case LIST:
                functionElement = TO_JAVA_LIST;
                break;
            case ARRAY:
                functionElement = TO_IOS_OBJECT_ARRAY;
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
            case LIST:
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
