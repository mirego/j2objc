package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructor;
import com.mirego.interop.kotlin.test.constructor.ClassWithoutConstructor;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorAsFunctionReference {

  public static String main(String[] args) {
    Supplier<ClassWithoutConstructor> aConstructorNoParams = ClassWithoutConstructor::new;
    Function<String,ClassWithDefaultConstructor> aConstructorSingleParam = ClassWithDefaultConstructor::new;
    return "Constructor no params: " + aConstructorNoParams.get().getName() + "\n" +
      "Constructor single param: " + aConstructorSingleParam.apply("VALUE_OF_THE_PARAM").getName();
  }
}
