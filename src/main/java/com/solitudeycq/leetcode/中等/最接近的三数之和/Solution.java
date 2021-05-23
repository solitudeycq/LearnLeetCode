package com.solitudeycq.leetcode.中等.最接近的三数之和;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(closeNum - target)) {
                    closeNum = sum;
                }
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return target;
                }
            }
        }
        return closeNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }
}