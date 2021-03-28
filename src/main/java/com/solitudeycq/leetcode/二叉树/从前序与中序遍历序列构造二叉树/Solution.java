package com.solitudeycq.leetcode.二叉树.从前序与中序遍历序列构造二叉树;


import com.solitudeycq.leetcode.common.TreeNode;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        return dfs2(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode dfs2(int[] preorder, int[] inorder, int h1, int t1, int h2, int t2) {
        //h1,t1,当前子树前序遍历数组的起始、结束位置，h2,t2，当前子树中序遍历数组；
        if (h2 > t2 || h1 > t1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[h1]);
        if (h1 == t1) {
            return root;
        }
        int mid = 0;
        while (inorder[h2 + mid] != root.val) {
            ++mid;
        }
        //左子树的前序遍历数组位置为h1+1,h1+mid（根据遍历特点），中序遍历数组为h1+mid位置的左边
        root.left = dfs2(preorder, inorder, h1 + 1, h1 + mid, h2, h2 + mid - 1);
        //右子树的前序遍历位置为遍历完根节点和左子树之后：h1+mid+1至t1；中序遍历为根节点的右边：h2+mid+1至t2
        root.right = dfs2(preorder, inorder, h1 + mid + 1, t1, h2 + mid + 1, t2);
        return root;
    }
}