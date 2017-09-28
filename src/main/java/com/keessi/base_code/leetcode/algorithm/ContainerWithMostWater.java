package com.keessi.base_code.leetcode.algorithm;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {2, 5, 7, 3, 4, 1};
        System.out.println(maxArea(height));
    }

    //Time Limit Exceeded
    private static int maxArea1(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int shortLine = height[i] < height[j] ? height[i] : height[j];
                max = max < shortLine * (j - i) ? shortLine * (j - i) : max;
            }
        }
        return max;
    }

    private static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(height[i] * (j - i), max);
                i++;
            } else {
                max = Math.max(height[j] * (j - i), max);
                j--;
            }
        }
        return max;
    }
}
