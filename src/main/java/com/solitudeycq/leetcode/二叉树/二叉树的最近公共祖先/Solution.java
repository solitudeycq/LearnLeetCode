package com.solitudeycq.leetcode.二叉树.二叉树的最近公共祖先;

import com.solitudeycq.leetcode.二叉树.common.TreeNode;

class Solution {
    /**
     * 节点p和节点q只有两种关系:父子关系 兄弟关系
     * 父子关系:
     * 1.节点p是节点q的子孙节点,即节点p出现在节点q的左或右子树中;返回q即可;
     * 2.节点q是节点p的子孙节点,即节点q出现在节点p的左或右子树中;返回p即可;
     * 兄弟关系:
     * 节点p,q分别出现在某节点的左子树或右子树中;返回该节点即可;
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //p,q在某节点左子树和右子树中
        if (left != null && right != null) {
            return root;
        }
        //左子树和右子树均没有p,q且也不会该节点
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }
}