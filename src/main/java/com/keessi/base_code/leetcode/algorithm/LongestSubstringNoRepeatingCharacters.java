package com.keessi.base_code.leetcode.algorithm;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringNoRepeatingCharacters {
    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int maxLength = 0;
        String maxSub = "";
        for (int i = 0; i < s.length(); i++) {

            if (maxSub.indexOf(s.charAt(i)) == -1) {
                maxSub += s.charAt(i);
                maxLength = maxLength < maxSub.length() ? maxSub.length() : maxLength;
            } else {
                maxLength = maxLength < maxSub.length() ? maxSub.length() : maxLength;
                maxSub = maxSub.substring(maxSub.indexOf(s.charAt(i)) + 1, maxSub.length()) + s.charAt(i);

            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}