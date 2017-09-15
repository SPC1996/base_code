package com.keessi.base_code.leetcode.algorithm;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123321));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(x);
            String origin = builder.toString();
            String reverse = builder.reverse().toString();
            return origin.equals(reverse);
        }
    }
}
