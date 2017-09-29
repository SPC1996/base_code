package com.keessi.base_code.leetcode.algorithm;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumCloest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 2));
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(closet)) {
                        closet = nums[i] + nums[j] + nums[k] - target;
                    }
                    if (nums[i] + nums[j] + nums[k] - target == 0) {
                        return target;
                    } else if (nums[i] + nums[j] + nums[k] < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return target + closet;
    }
}
