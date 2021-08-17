package com.suraj.leetcode.solutions

object RegularExpressionMatching {
    def isMatch(s: String, p: String): Boolean = {
        if (p.isEmpty) return s.isEmpty
        val foundFirstMatch = s.nonEmpty && (s.charAt(0).equals(p.charAt(0)) || p.charAt(0).equals('.'))

        if (p.length >= 2 && p.charAt(1).equals('*')) {
            isMatch(s, p.substring(2)) || (foundFirstMatch && isMatch(s.substring(1), p))
        } else {
            foundFirstMatch && isMatch(s.substring(1), p.substring(1))
        }
    }
}
