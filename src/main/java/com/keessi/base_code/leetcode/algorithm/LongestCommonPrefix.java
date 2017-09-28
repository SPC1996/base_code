package com.keessi.base_code.leetcode.algorithm;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"abc", "abd", "ab"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (minLen > str.length()) {
                minLen = str.length();
            }
        }
        if (minLen < 1 || strs.length < 1) {
            return "";
        }
        StringBuilder prefix = new StringBuilder();
        char current;
        for (int i = 0; i < minLen; i++) {
            current = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (current != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                prefix.append(current);
            } else {
                break;
            }
        }
        return prefix.toString();
    }
}
