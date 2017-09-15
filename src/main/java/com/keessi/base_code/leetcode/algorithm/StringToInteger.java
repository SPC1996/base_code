package com.keessi.base_code.leetcode.algorithm;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("+-2"));
    }

    private static int myAtoi(String str) {
        char[] chars = str.trim().toCharArray();
        StringBuilder builder = new StringBuilder();
        if (chars.length == 0) {
            return 0;
        }
        if (chars[0] == '-' || Character.isDigit(chars[0])) {
            builder.append(chars[0]);
        } else if (chars[0] == '+') {
            builder.append("");
        } else {
            return 0;
        }
        for (int i = 1; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                builder.append(chars[i]);
            } else {
                break;
            }
        }
        if (builder.length() == 0) {
            return 0;
        }
        if (builder.length() == 1 && !Character.isDigit(builder.charAt(0))) {
            return 0;
        }
        try {
            return Integer.parseInt(builder.toString());
        } catch (Exception e) {
            if (builder.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}
