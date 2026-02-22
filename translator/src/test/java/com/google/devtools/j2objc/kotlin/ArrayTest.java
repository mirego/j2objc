package com.google.devtools.j2objc.kotlin;

import com.google.devtools.j2objc.GenerationTest;

import com.mirego.interop.java.test.array.Array1_length;
import com.mirego.interop.java.test.array.Array2_getAtIndex;
import com.mirego.interop.java.test.array.Array3_setAtIndex;
import com.mirego.interop.java.test.array.Array4_enhancedForLoop;
import com.mirego.interop.java.test.array.ByteArrayVsArrayOfByte;

public class ArrayTest extends GenerationTest {

  final private static String testPackage = "array/";

  public void testArrayLength() throws Exception {
    String className = Array1_length.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
    assertTranslation(translation, "((IOSObjectArray *) nil_chk(toIOSObjectArray([arrayBasics emptyArray])))->size_");
    assertTranslation(translation, "((IOSObjectArray *) nil_chk(toIOSObjectArray([arrayBasics singleItemArray])))->size_");
    assertTranslation(translation, "((IOSObjectArray *) nil_chk(toIOSObjectArray([arrayBasics manyItemArray])))->size_");
  }

  public void testArrayGet() throws Exception {
    String className = Array2_getAtIndex.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
    assertTranslation(translation, "IOSObjectArray_Get(nil_chk(toIOSObjectArray([arrayBasics manyItemArray]))");
  }

  public void testArraySet() throws Exception {
    String className = Array3_setAtIndex.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
    assertTranslation(translation, "toIOSObjectArray([arrayBasics manyItemArray])");
    assertTranslation(translation, "IOSObjectArray_Set(manyItemArray, 3, @\"ZZZ\")");
  }

  public void testEnhancedForLoop() throws Exception {
    String className = Array4_enhancedForLoop.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
    assertTranslation(translation, "toIOSObjectArray([arrayBasics manyItemArray])");
  }

  public void testByteArray() throws Exception {
    String className = ByteArrayVsArrayOfByte.class.getSimpleName();
    String translation = translateJavaSourceFileForKotlinTest(className, testPackage, ".m");
    assertTranslation(translation, "IOSObjectArray *arrayOfByte = toIOSObjectArray([arrayBasics arrayOfByte]);");
    assertTranslation(translation, "IOSByteArray *byteArray = toIOSByteArray([arrayBasics byteArray]);");
  }
}
