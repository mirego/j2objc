package com.mirego.interop.java.test.function;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mirego.interop.kotlin.test.function.ClassWithFunctionsReceivingCollectionTypes;

public class FunctionReceivingCollectionParam {

  public static String main(String[] args) {

    ClassWithFunctionsReceivingCollectionTypes testClass = new ClassWithFunctionsReceivingCollectionTypes();
    List<String> stringList = Collections.singletonList("test");
    testClass.receive(stringList);
    Set<String> stringSet = Collections.singleton("test");
    testClass.receive(stringSet);
    Map<String, String> stringMap = Collections.singletonMap("test", "test");
    testClass.receive(stringMap);
    Collection<String> stringCollection = Arrays.asList("test", "test2");
    testClass.receive(stringCollection);

    return "OK";
  }
}
