package com.keessi.base_code.leetcode.algorithm;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * <p>
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    private static int reverse(int x) {
        StringBuilder builder = new StringBuilder();
        builder.append(Math.abs((long) x));
        builder.reverse();
        if ((long) x < 0)
            builder.insert(0, '-');
        long res = Long.parseLong(builder.toString());
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
            return 0;
        else
            return (int) res;
    }
}
