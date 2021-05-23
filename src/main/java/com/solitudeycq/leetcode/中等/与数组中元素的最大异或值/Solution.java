package com.solitudeycq.leetcode.中等.与数组中元素的最大异或值;

import java.util.Arrays;

class Solution {
    // 超时
    public int[] maximizeXor(int[] nums, int[][] queries) {
        if (nums == null || nums.length == 0 || queries == null || queries.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (nums[0] > query[1]) {
                result[i] = -1;
                continue;
            }
            int max = query[0] ^ nums[0];
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] <= query[1]) {
                    max = Math.max(max, query[0] ^ nums[j]);
                } else {
                    break;
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.maximizeXor(new int[]{5, 2, 4, 6, 6, 3}, new int[][]{{12, 4}, {8, 1}, {6, 3}});
        System.out.println();
    }
}