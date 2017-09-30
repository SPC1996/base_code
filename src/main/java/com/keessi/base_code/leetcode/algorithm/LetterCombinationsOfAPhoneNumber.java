package com.keessi.base_code.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    private static List<String> letterCombinations(String digits) {
        String[] map = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            int digit = Integer.parseInt(digits.charAt(i) + "");
            int size = res.size();
            if (size == 0) {
                for (int j = 0; j < map[digit - 1].length(); j++) {
                    res.add(map[digit - 1].charAt(j) + "");
                }
            } else {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < map[digit - 1].length(); k++) {
                        res.add(res.get(0) + map[digit - 1].charAt(k));
                    }
                    res.remove(0);
                }
            }
        }
        return res;
    }
}
