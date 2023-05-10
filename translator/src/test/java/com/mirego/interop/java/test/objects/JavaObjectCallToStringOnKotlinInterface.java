package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.interfaces.InterfaceSimple;

public class JavaObjectCallToStringOnKotlinInterface {

  public static String main(String[] args) {
    InterfaceSimple aKotlinInterface = null;

    // Must check for null to ensure the nil_chk" optimization kicks-in...
    if (aKotlinInterface == null) {
      return "";
    }

    // ... and there is no nil_chk() on this line
    return aKotlinInterface.toString();
  }
}
