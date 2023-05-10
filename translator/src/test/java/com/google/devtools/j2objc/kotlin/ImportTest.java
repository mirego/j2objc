package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import org.junit.Test;

import java.io.IOException;

import com.mirego.interop.java.test.imports.ImportTest_ExposingKotlinTypeInPublicApi;

public class ImportTest extends GenerationTest {

  final private static String testPackage = "imports/";

  @Test
  public void testImportInHeaderFile() throws IOException {
    String className = ImportTest_ExposingKotlinTypeInPublicApi.class.getSimpleName();
    String generatedHeaderFile = translateJavaSourceFileForKotlinTest(className, testPackage, ".h");
    String generatedFile = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");

    assertTranslation(generatedHeaderFile, "@class CommonSimpleEnum;");
    assertNotInTranslation(generatedFile, "SimpleEnum.h");
  }

}
