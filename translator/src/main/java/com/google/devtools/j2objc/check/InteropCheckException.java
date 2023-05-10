// kotlin interop >>

package com.google.devtools.j2objc.check;

public class InteropCheckException extends RuntimeException {

    public InteropCheckException(String errorsStr) {
        super("J2ObjC: Found Kotlin Interop check errors in sources:\n" + errorsStr);
    }
}

// kotlin interop <<
