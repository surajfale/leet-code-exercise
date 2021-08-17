package com.suraj.leetcode.solutions

import com.suraj.leetcode.solutions.base.TestBaseClass

class RegularExpressionMatchingTest extends TestBaseClass {
    test("Test Case 1") {
        testResults(inputString = "mississippi", pattern = "mississippi", expected = true)
    }

    test("Test Case 2") {
        testResults(inputString = "aa", pattern = "p", expected = false)
    }

    test("Test Case 3") {
        testResults(inputString = "aa", pattern = "a*", expected = true)
    }

    test("Test Case 4") {
        testResults(inputString = "ab", pattern = ".*", expected = true)
    }

    test("Test Case 5") {
        testResults(inputString = "aab", pattern = "c*a*b", expected = true)
    }

    test("Test Case 6") {
        testResults(inputString = "mississippi", pattern = "mis*is*p*.", expected = false)
    }

    test("Test Case 7") {
        testResults(inputString = "aaa", pattern = "a*a", expected = true)
    }

    test("Test Case 8") {
        testResults(inputString = "ab", pattern = ".*c", expected = false)
    }

    test("Test Case 9") {
        testResults(inputString = "aaa", pattern = "aaaa", expected = false)
    }

    test("Test Case 10") {
        testResults(inputString = "aaa", pattern = "ab*a*c*a", expected = true)
    }

    def testResults(inputString: String, pattern: String, expected: Boolean): Unit = {
        assertResult(expected)(RegularExpressionMatching.isMatch(inputString, pattern))
    }
}
