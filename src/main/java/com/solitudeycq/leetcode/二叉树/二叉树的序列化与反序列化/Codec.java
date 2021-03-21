package com.solitudeycq.leetcode.二叉树.二叉树的序列化与反序列化;

import com.solitudeycq.leetcode.二叉树.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    public String serializeHelper(TreeNode treeNode, String str) {
        if (treeNode == null) {
            str += "null,";
        } else {
            str = str + treeNode.val + ",";
            str = serializeHelper(treeNode.left, str);
            str = serializeHelper(treeNode.right, str);
        }
        return str;
    }

    /**
     * 层序遍历
     *
     * @param root root
     * @return result
     */
    public String serialize(TreeNode root) {
        return serializeHelper(root, "");
    }

    private TreeNode deserializeHelper(List<String> numStrs) {
        if ("null".equals(numStrs.get(0))) {
            numStrs.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(numStrs.get(0)));
        numStrs.remove(0);
        root.left = deserializeHelper(numStrs);
        root.right = deserializeHelper(numStrs);
        return root;
    }

    public TreeNode deserialize(String data) {
        return deserializeHelper(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode4.left = treeNode6;
        treeNode4.right = treeNode7;
        TreeNode treeNode = codec.deserialize(codec.serialize(treeNode1));
        System.out.println();
    }
}