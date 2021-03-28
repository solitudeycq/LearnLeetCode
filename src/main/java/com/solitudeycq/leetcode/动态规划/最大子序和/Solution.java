package com.solitudeycq.leetcode.动态规划.最大子序和;

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}