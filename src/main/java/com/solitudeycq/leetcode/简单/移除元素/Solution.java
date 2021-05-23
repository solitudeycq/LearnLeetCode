package com.solitudeycq.leetcode.简单.移除元素;

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int repeat = 0;
        int i = 0;
        while (i < nums.length - repeat) {
            if (nums[i] == val) {
                repeat++;
                for (int j = i; j <= (nums.length - repeat - 1); j++) {
                    nums[j] = nums[j + 1];
                }
            } else {
                i++;
            }
        }
        return nums.length - repeat;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}