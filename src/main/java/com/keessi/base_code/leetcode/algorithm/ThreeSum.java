package com.keessi.base_code.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(threeSum(nums));
    }

    //最后去重会超时
    private static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            int j = 0, k = nums.length - 1;
            while (j < i && k > i) {
                if (nums[j] + nums[k] == 0 - nums[i]) {
                    lists.add(Arrays.asList(nums[j], nums[i], nums[k]));
                    j++;
                    k--;
                } else if (nums[j] + nums[k] < 0 - nums[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        HashSet<List<Integer>> set = new HashSet<>(lists);
        lists.clear();
        lists.addAll(set);
        return lists;
    }

    //循环中去重，固定最小的数
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    if (nums[j] + nums[k] == 0 - nums[i]) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < 0 - nums[i]) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return lists;
    }
}
