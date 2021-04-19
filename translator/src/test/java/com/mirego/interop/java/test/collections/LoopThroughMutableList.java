package com.mirego.interop.java.test.collections;

import com.mirego.interop.kotlin.test.collections.KotlinLists;

import java.util.List;

public class LoopThroughMutableList {

    public static String main(String[] args) {

        KotlinLists kotlinLists = new KotlinLists();

        List<String> list = kotlinLists.getMutableList();
        String output = "";
        for(String element: list) {
            output += element;
        }
        return output;
    }
}