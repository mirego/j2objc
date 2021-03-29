/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.j2objc;

import com.google.devtools.j2objc.kotlin.ConstructorTest;
import com.google.devtools.j2objc.kotlin.DataClassTest;
import com.google.devtools.j2objc.kotlin.EnumsTest;
import com.google.devtools.j2objc.kotlin.FunctionTest;
import com.google.devtools.j2objc.kotlin.InterfacesTest;
import com.google.devtools.j2objc.kotlin.ObjectsTest;
import com.google.devtools.j2objc.kotlin.PropertyTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Returns a suite of all kotlin interop tests in this package.
 */
public class KotlinInteropTests {

  private static final Class<?>[] kotlinInteropClasses =
      new Class<?>[] {
              ConstructorTest.class,
              InterfacesTest.class,
              FunctionTest.class,
              InterfacesTest.class,
              ObjectsTest.class,
              PropertyTest.class,
              DataClassTest.class,
              EnumsTest.class,
      };


  public static Test suite() {
    return new TestSuite(kotlinInteropClasses);
  }
}
