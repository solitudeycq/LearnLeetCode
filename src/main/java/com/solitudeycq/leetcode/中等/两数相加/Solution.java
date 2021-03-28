package com.solitudeycq.leetcode.中等.两数相加;

import com.solitudeycq.leetcode.common.ListNode;


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = null;
        ListNode trail = null;
        int count = 0;
        boolean needAddOne = false;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + (needAddOne ? 1 : 0);
            if (num >= 10) {
                needAddOne = true;
                num = num % 10;
            } else {
                needAddOne = false;
            }
            ListNode listNode = new ListNode(num);
            if (count == 0) {
                head = listNode;
                trail = head;
                count++;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }
            trail.next = listNode;
            trail = listNode;
            l1 = l1.next;
            l2 = l2.next;
            count++;
        }
        while (l1 != null) {
            int num = l1.val + (needAddOne ? 1 : 0);
            if (num >= 10) {
                needAddOne = true;
                num = num % 10;
            } else {
                needAddOne = false;
            }
            ListNode listNode = new ListNode(num);
            trail.next = listNode;
            trail = listNode;
            l1 = l1.next;
        }

        while (l2 != null) {
            int num = l2.val + (needAddOne ? 1 : 0);
            if (num >= 10) {
                needAddOne = true;
                num = num % 10;
            } else {
                needAddOne = false;
            }
            ListNode listNode = new ListNode(num);
            trail.next = listNode;
            trail = listNode;
            l2 = l2.next;
        }
        if (needAddOne) {
            trail.next = new ListNode(1);
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(0);

        ListNode listNode4 = new ListNode(0);

        solution.addTwoNumbers(listNode1, listNode4);
    }
}