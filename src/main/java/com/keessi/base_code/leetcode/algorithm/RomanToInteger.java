package com.keessi.base_code.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("VII"));
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (s.length() < 1) {
            return 0;
        }
        int pre = map.get(s.charAt(0)), current, sub = pre, res = 0;
        for (int i = 1; i < s.length(); i++) {
            current = map.get(s.charAt(i));
            if (current == pre) {
                sub += current;
            } else if (current > pre) {
                sub = current - sub;
            } else {
                res += sub;
                sub = current;
            }
            pre = current;
        }
        res += sub;
        return res;
    }
}
