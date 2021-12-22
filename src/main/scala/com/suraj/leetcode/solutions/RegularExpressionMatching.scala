package com.suraj.leetcode.solutions

/**
 * LeetCode example: [[https://leetcode.com/problems/regular-expression-matching/]]
 */
object RegularExpressionMatching {
    def isMatch(s: String, p: String): Boolean = {
        if p.isEmpty then return s.isEmpty
        val foundFirstMatch = s.nonEmpty && (s.charAt(0).equals(p.charAt(0)) || p.charAt(0).equals('.'))

        if p.length >= 2 && p.charAt(1).equals('*') then
            isMatch(s, p.substring(2)) || (foundFirstMatch && isMatch(s.substring(1), p))
        else
            foundFirstMatch && isMatch(s.substring(1), p.substring(1))
    }
}
