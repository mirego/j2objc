/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package libcore.java.net;

import java.io.IOException;
import java.net.BindException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
/* J2ObjC removed: not supported by Junit 4.11 (https://github.com/google/j2objc/issues/1318).
import libcore.junit.junit3.TestCaseWithRules;
import libcore.junit.util.ResourceLeakageDetector;
 */
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.rules.TestRule;

public class ServerSocketTest extends TestCase /* J2ObjC removed: TestCaseWithRules */ {
    /* J2ObjC removed: not supported by Junit 4.11 (https://github.com/google/j2objc/issues/1318).
    @Rule
    public TestRule guardRule = ResourceLeakageDetector.getRule();
     */

    public void testTimeoutAfterAccept() throws Exception {
        try (ServerSocket ss = new ServerSocket(0)) {
            ss.setReuseAddress(true);
            // On Unix, the receive timeout is inherited by the result of accept(2).
            // Java specifies that it should always be 0 instead.
            ss.setSoTimeout(1234);
            final Socket[] result = new Socket[1];
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        result[0] = ss.accept();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        fail();
                    }
                }
            });
            t.start();
            new Socket(ss.getInetAddress(), ss.getLocalPort()).close();
            t.join();
            assertEquals(0, result[0].getSoTimeout());
        }
    }

    public void testInitialState() throws Exception {
        ServerSocket ss = new ServerSocket();
        try {
            assertFalse(ss.isBound());
            assertFalse(ss.isClosed());
            assertEquals(-1, ss.getLocalPort());
            assertNull(ss.getLocalSocketAddress());
            assertNull(ss.getInetAddress());
            assertTrue(ss.getReuseAddress());
            assertNull(ss.getChannel());
        } finally {
            ss.close();
        }
    }

    public void testStateAfterClose() throws Exception {
        ServerSocket ss = new ServerSocket();
        try {
            ss.bind(new InetSocketAddress(Inet4Address.getLocalHost(), 0));
        } catch (BindException e) {
            // Continuous build environment doesn't support localhost sockets.
            return;
        }
        InetSocketAddress boundAddress = (InetSocketAddress) ss.getLocalSocketAddress();
        ss.close();

        assertTrue(ss.isBound());
        assertTrue(ss.isClosed());
        assertEquals(boundAddress.getAddress(), ss.getInetAddress());
        assertEquals(boundAddress.getPort(), ss.getLocalPort());

        InetSocketAddress localAddressAfterClose = (InetSocketAddress) ss.getLocalSocketAddress();
        assertEquals(boundAddress, localAddressAfterClose);
    }
}
