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

abstract class AbstractJavaVersionsTest extends GroovyTestCase {

    abstract def getVersionChecker(String version)

    private void assertVersions(String version, boolean is1_7, boolean is1_8, boolean isNewer) {
        def verChk = getVersionChecker(version)
        assert verChk.is1_7() == is1_7
        assert verChk.is1_8() == is1_8
        assert verChk.is1_7OrLater() == isNewer || is1_8 || is1_7
        assert verChk.is1_8OrLater() == isNewer || is1_8
    }

    void testJava1dot7() {
        assertVersions("1.7.0_80", true, false, false)
    }

    void testJava1dot8() {
        assertVersions("1.8.0_181", false, true, false)
    }

    void testJava9() {
        assertVersions("9.0.4", false, false, true)
    }

    void testJava10() {
        assertVersions("10.0.2", false, false, true)
    }

    void testJava11() {
        assertVersions("11", false, false, true)
    }

    void testJava12ea() {
        assertVersions("12-ea", false, false, true)
    }
}
