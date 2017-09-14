package com.keessi.base_code.leetcode.algorithm;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccca"));
    }

    private static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            int len = Math.max(getMax(chars, i, i), getMax(chars, i, i + 1));
            if (len > max) {
                max = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + max);
    }

    private static int getMax(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
