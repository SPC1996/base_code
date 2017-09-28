package com.keessi.base_code.leetcode.algorithm;

/**
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }

    private static String intToRoman(int num) {
        String[][] base = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        return base[3][num / 1000 % 10] +
                base[2][num / 100 % 10] +
                base[1][num / 10 % 10] +
                base[0][num % 10];
    }
}
