package com.keessi.base_code.leetcode.algorithm;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 1));
    }

    private static String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }
        char[][] chars = new char[nRows][(s.length() + 1) / 2];
        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0, count = 0, state = 0;
        while (count < s.length()) {
            chars[i][j] = s.charAt(count);
            if (i > 0 && i < nRows - 1 && state == 0) {
                i++;
            } else if (i > 0 && i < nRows - 1 && state == 1) {
                i--;
                j++;
            } else if (i == nRows - 1) {
                state = 1;
                i--;
                j++;
            } else if (i == 0) {
                state = 0;
                i++;
            }
            count++;
        }
        for (char[] row : chars)
            for (char cell : row)
                if (cell != '\u0000')
                    builder.append(cell);
        return builder.toString();
    }
}
