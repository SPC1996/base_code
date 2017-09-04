package com.keessi.base_code.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers,
 * return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author SPC
 */
public class TwoSum {
    private static int[] twoSum(int nums[], int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                return new int[]{numMap.get(nums[i]), i};
            } else {
                numMap.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        if (result != null)
            System.out.println("[" + result[0] + "," + result[1] + "]");
        else
            System.out.println("null");
    }
}
