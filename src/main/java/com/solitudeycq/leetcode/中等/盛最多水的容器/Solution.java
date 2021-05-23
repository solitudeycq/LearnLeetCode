package com.solitudeycq.leetcode.中等.盛最多水的容器;

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int tmp = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, tmp);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}