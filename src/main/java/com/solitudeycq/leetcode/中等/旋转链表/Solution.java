package com.solitudeycq.leetcode.中等.旋转链表;

import com.solitudeycq.leetcode.common.ListNode;


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode item = head;
        while (item.next != null) {
            n++;
            item = item.next;
        }
        int realRotate = k % n;
        if (realRotate == 0) {
            return head;
        } else {
            item.next = head;
            int j = n - realRotate;
            while (j > 0) {
                j--;
                item = item.next;
            }
            ListNode result = item.next;
            item.next = null;
            return result;
        }
    }
}