package com.keessi.base_code.leetcode.algorithm;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortArrays {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] shortArray, longArray;
        int shortLength, longLength;
        if (nums1.length > nums2.length) {
            shortArray = nums2;
            shortLength = nums2.length;
            longArray = nums1;
            longLength = nums1.length;
        } else {
            shortArray = nums1;
            shortLength = nums1.length;
            longArray = nums2;
            longLength = nums2.length;
        }
        int imin = 0, imax = shortLength, half = (shortLength + longLength + 1) / 2;
        while (imin <= imax) {
            int imid = (imin + imax) / 2;
            int jmid = half - imid;
            if (imid < shortLength && longArray[jmid - 1] > shortArray[imid])
                imin = imid + 1;
            else if (imid > 0 && shortArray[imid - 1] > longArray[jmid])
                imax = imid - 1;
            else {
                double minOfRight, maxOfLeft;
                if (imid == 0)
                    maxOfLeft = longArray[jmid - 1];
                else if (jmid == 0)
                    maxOfLeft = shortArray[imid - 1];
                else
                    maxOfLeft = Math.max(shortArray[imid - 1], longArray[jmid - 1]);

                if ((shortLength + longLength) % 2 == 1)
                    return maxOfLeft;

                if (imid == shortLength)
                    minOfRight = longArray[jmid];
                else if (jmid == longLength)
                    minOfRight = shortArray[imid];
                else
                    minOfRight = Math.min(shortArray[imid], longArray[jmid]);

                return (maxOfLeft + minOfRight) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
