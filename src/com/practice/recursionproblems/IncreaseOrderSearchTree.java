package com.practice.recursionproblems;

/**Problem statement:
Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost
 node in the tree is now the root of the tree, and every node has no left child and only one right child.

 Leetcode link: https://leetcode.com/problems/increasing-order-search-tree/description/
 **/
public class IncreaseOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.left == null && root.right == null) {
            return new TreeNode(root.val);
        }
        TreeNode head = increasingBST(root.left);
        TreeNode tail = new TreeNode();
        if (head != null) {
            tail = head;
            while (tail.right != null) {
                tail = tail.right;
            }
            tail.right = new TreeNode(root.val);
            TreeNode rightHead = increasingBST(root.right);
            tail.right.right = rightHead;
        } else {
            head = new TreeNode(root.val);
            head.right = increasingBST(root.right);
        }
        return head;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

