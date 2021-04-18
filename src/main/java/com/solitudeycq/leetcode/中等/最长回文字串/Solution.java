package com.solitudeycq.leetcode.中等.最长回文字串;


class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandHelper(s, i, i);
            int len2 = expandHelper(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandHelper(String s, int leftStart, int rightStart) {
        while (leftStart >= 0 && rightStart < s.length() && s.charAt(leftStart) == s.charAt(rightStart)) {
            --leftStart;
            ++rightStart;
        }
        return rightStart - leftStart - 1;
    }
}