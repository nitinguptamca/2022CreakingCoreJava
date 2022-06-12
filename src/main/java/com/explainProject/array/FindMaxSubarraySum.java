package com.explainProject.array;

/**
 * Given an integer array, find the maximum sum among all its subarrays.
 * <p>
 * Input : [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6
 * Explanation: The maximum sum subarray is [4, -1, 2, 1]
 * <p>
 * Input : [-7, -3, -2, -4]
 * Output: -2
 * Explanation: The maximum sum subarray is [-2]
 * <p>
 * Input : [-2, 2, -1, 2, 1, 6, -10, 6, 4, -8]
 * Output: 10
 * Explanation: The maximum sum subarray is [2, -1, 2, 1, 6] or [6, 4] or [2, -1, 2, 1, 6, -10, 6, 4]
 */

public class FindMaxSubarraySum {
    public static int findMaxSubarraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
       // int sum = 0;
        // do for each subarray starting with `i`
        for (int i = 0; i < nums.length; i++) {
            // calculate the sum of subarray `nums[i…j]`
           int sum = 0;    // reset sum
            // do for each subarray ending at `j`
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                // if the current subarray sum is greater than the maximum
                // sum calculated so far, update the maximum sum
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int[] nums = {-2, 2, -1, 2, 1, 6, -10, 6, 4, -8};
        System.out.println(findMaxSubarraySum(nums));
    }
}
