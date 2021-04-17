package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithPublicFunctionReturningUnit;

public class PublicFunctionReturningUnit {

    public static ClassWithPublicFunctionReturningUnit main(String[] args) {

        ClassWithPublicFunctionReturningUnit classWithPublicFunctionReturningUnit = new ClassWithPublicFunctionReturningUnit();

        classWithPublicFunctionReturningUnit.returnUnit();
        return classWithPublicFunctionReturningUnit;
    }
}
