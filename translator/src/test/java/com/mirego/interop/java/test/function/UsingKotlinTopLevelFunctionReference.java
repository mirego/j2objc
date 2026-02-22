package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.KotlinFileWithTopLevelFunctionKt;
import java.util.function.Function;

public class UsingKotlinTopLevelFunctionReference {

  private static class MyInnerClass {

    public MyInnerClass() {

    }

    public static String pingStatic(String msg) {
      return "pong: " + msg;
    }

    public String pingInstance(String msg) {
      return "pong: " + msg;
    }
  }

  public static String main(String[] args) {

    Function<String, String> f0 = KotlinFileWithTopLevelFunctionKt::aTopLevelFunction;
    Function<String, String> f1 = MyInnerClass::pingStatic;
    Function<String, String> f2 = new MyInnerClass()::pingInstance;

    String r0 = f0.apply("yo!");
    String r1 = f1.apply("hello");
    String r2 = f2.apply("world");
    return r0 +r1 + r2;
  }
}
