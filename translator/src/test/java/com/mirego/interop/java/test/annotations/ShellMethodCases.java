package com.mirego.interop.java.test.annotations;

import com.google.j2objc.annotations.J2ObjCShellMethod;

public class ShellMethodCases {
  public static String main(String[] args) {
    ClassWithAShellMethod classWithAShellMethod = new ClassWithAShellMethod();
    return classWithAShellMethod.getStringStillPresent();
  }

  public static class ClassWithAShellMethod {
    @J2ObjCShellMethod
    private String getStringShell() {
      return "removed";
    }

    private String getStringStillPresent() {
      return "kept";
    }
  }

  @J2ObjCShellMethod
  public static class ClassWithAConstructorWithoutParams extends BaseClassWithConstructorParam {
    public ClassWithAConstructorWithoutParams() {
      super("baseClassParam");
    }

    private String getStringShell() {
      return "removed";
    }

    public String getInternal() {
      return internal;
    }
  }

  private static class BaseClassWithConstructorParam {
    protected String internal;

    public BaseClassWithConstructorParam(String internal) {
      this.internal = internal;
    }
  }
}
