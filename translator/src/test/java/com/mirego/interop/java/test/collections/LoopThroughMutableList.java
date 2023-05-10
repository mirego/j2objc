package com.mirego.interop.java.test.collections;

import java.util.List;

import com.mirego.interop.kotlin.test.collections.KotlinLists;

public class LoopThroughMutableList {

  public static String main(String[] args) {

    KotlinLists kotlinLists = new KotlinLists();

    List<String> list = kotlinLists.getMutableList();
    String output = "";
    for (String element : list) {
      output += element;
    }
    return output;
  }
}
