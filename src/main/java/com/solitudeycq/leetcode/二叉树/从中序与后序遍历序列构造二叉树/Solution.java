package com.solitudeycq.leetcode.二叉树.从中序与后序遍历序列构造二叉树;

import com.solitudeycq.leetcode.二叉树.common.TreeNode;


class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) {
            return null;
        }
        return dfs(inorder, postorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode dfs(int[] inorder, int[] postorder, int head1, int tail1, int head2, int tail2) {
        if (head2 > tail2) {
            return null;
        }
        int val = postorder[tail2];
        TreeNode root = new TreeNode(val);
        if (head2 == tail2) {
            return root;
        }
        int mid = 0;
        while (inorder[head1 + mid] != val) {
            mid++;
        }
        root.left = dfs(inorder, postorder, head1, head1 + mid - 1, head2, head2 + mid - 1);
        root.right = dfs(inorder, postorder, head1 + mid + 1, tail1, head2 + mid, tail2 - 1);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}
