package com.solitudeycq.leetcode.二叉树.二叉搜索树迭代器;

import com.solitudeycq.leetcode.common.TreeNode;

import java.util.*;

class BSTIterator {
    private List<TreeNode> nodeList;
    private Iterator<TreeNode> iterator;

    public BSTIterator(TreeNode root) {
        if (root == null) {
            return;
        }
        nodeList = new ArrayList<>();
        inorder(root, nodeList);
        iterator = nodeList.listIterator();
    }

    private void inorder(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }

    public int next() {
        return iterator.next().val;
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}