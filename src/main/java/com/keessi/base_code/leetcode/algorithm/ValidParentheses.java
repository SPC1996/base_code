package com.keessi.base_code.leetcode.algorithm;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order,
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}{";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String combine = stack.pop() + "" + c;
                if (!(combine.equals("()") || combine.equals("[]") || combine.equals("{}"))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
