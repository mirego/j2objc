package com.mirego.interop.java.test.collections;

import com.mirego.interop.kotlin.test.collections.KotlinLists;

import java.util.List;

public class LoopThroughList {

    public static String main(String[] args) {

        KotlinLists kotlinLists = new KotlinLists();

        List<String> list = kotlinLists.getList();
        String output = "";
        for (String element : list) {
            output += element;
        }
        return output;
    }
}
