package com.mirego.interop.java.test.dataclass;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mirego.interop.kotlin.test.dataclass.DataClassWithFieldsOfCollectionTypes;

public class DataClassInitializedWithCollectionFields {

  public static String main(String[] args) {
    Collection<String> stringCollection = Arrays.asList("test", "test2");
    List<String> stringList = Collections.singletonList("test");
    Set<String> stringSet = Collections.singleton("test");
    Map<String, String> stringMap = Collections.singletonMap("test", "test");

    new DataClassWithFieldsOfCollectionTypes(
        stringCollection,
        stringList,
        stringSet,
        stringMap
    );

    return "OK";
  }
}
