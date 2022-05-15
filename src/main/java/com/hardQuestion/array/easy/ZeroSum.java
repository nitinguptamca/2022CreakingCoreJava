package com.hardQuestion.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array, check if it contains a contiguous subarray having zero-sum.
 * <p>
 * Input : [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]
 * Output: true
 * Explanation: The subarrays with zero-sum are
 * <p>
 * [3, 4, -7]
 * [4, -7, 3]
 * [-7, 3, 1, 3]
 * [3, 1, -4]
 * [3, 1, 3, 1, -4, -2, -2]
 * [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]
 * <p>
 * Input : [4, -7, 1, 2, -1]
 * Output: false
 * Explanation: The subarray with zero-sum doesn't exist.
 */

public class ZeroSum {
    public static boolean hasZeroSumSubarray(int[] nums) {
        int sum = 0;
        Set<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i <= nums.length - 1; i++) {
            sum += nums[i];
            if (nums[i] == 0
                    || sum == 0
                    || hs.contains(sum)
            )
                return true;
            // Add sum to hash set
            hs.add(sum);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, -4, -1, 1};
        System.out.println(hasZeroSumSubarray(nums));
    }
}