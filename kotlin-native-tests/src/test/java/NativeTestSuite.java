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

import junit.framework.Test;
import junit.framework.TestSuite;

// import ConstructorTests;
// import Constructor2Tests;

/**
 * Returns a suite of all small tests in this package.
 */
public class NativeTestSuite {

    private static final Class<?>[] nativeTests =
        new Class<?>[]{
            ConstructorTests.class,
            Constructor2Tests.class
        };

    public static Test suite() {
        return new TestSuite(nativeTests);
    }
}
