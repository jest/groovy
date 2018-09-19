/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.groovy.json.internal

class SysTest extends AbstractJavaVersionsTest {

    static class SysWrapper {
        Sys s
        boolean is1_7() { s.is1_7 }
        boolean is1_8() { s.is1_8 }
        boolean is1_7OrLater() { true }
        boolean is1_8OrLater() { s.is1_8OrLater }
    }

    def getVersionChecker(String version) {
        new SysWrapper(s : new Sys(version))
    }
}
