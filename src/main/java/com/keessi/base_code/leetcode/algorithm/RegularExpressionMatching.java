package com.keessi.base_code.leetcode.algorithm;

import java.util.regex.Pattern;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("def", "c*a*b"));
    }

    private static boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(s).matches();
    }
}
