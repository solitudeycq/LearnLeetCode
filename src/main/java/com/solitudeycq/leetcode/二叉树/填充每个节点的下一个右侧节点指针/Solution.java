package com.solitudeycq.leetcode.二叉树.填充每个节点的下一个右侧节点指针;

import com.solitudeycq.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 层序遍历
     *
     * @param root root
     * @return root
     */
    public Node connect(Node root) {
        if (root != null) {
            List<Node> left = new ArrayList<>();
            List<Node> right = new ArrayList<>();
            left.add(root);
            while (left.size() != 0 || right.size() != 0) {
                if (left.size() != 0) {
                    for (int i = 0; i < left.size(); i++) {
                        if (left.get(i).left != null) {
                            right.add(left.get(i).left);
                        }
                        if (left.get(i).right != null) {
                            right.add(left.get(i).right);
                        }
                        if (i == left.size() - 1) {
                            left.get(i).next = null;
                            continue;
                        }
                        left.get(i).next = left.get(i + 1);
                    }
                    left.clear();
                }
                if (right.size() != 0) {
                    for (int j = 0; j < right.size(); j++) {
                        if (right.get(j).left != null) {
                            left.add(right.get(j).left);
                        }
                        if (right.get(j).right != null) {
                            left.add(right.get(j).right);
                        }
                        if (j == right.size() - 1) {
                            right.get(j).next = null;
                            continue;
                        }
                        right.get(j).next = right.get(j + 1);
                    }
                    right.clear();
                }
            }
        }
        return root;
    }
}