package com.practice.recursionproblems;

import java.util.*;
/**Problem statement:
 Given the root of a binary tree, return the sum of values of its deepest leaves.
 
 Example 1:
 Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 Output: 15

 Example 2:
 Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 Output: 19

 Constraints:
 The number of nodes in the tree is in the range [1, 104].
 1 <= Node.val <= 100

 Leetcode link: https://leetcode.com/problems/deepest-leaves-sum/description/
 **/


public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        return findSum(root);
    }
    public static int findSum(TreeNode root) {
        Queue < TreeNode > q = new ArrayDeque < > ();
        q.add(root);
        int size = q.size();
        int sum = 0;

        while (!q.isEmpty()) {
            size = q.size();
            sum = addUpElementsInQueue(q);

            for (int i = 0; i < size; i++) {
                TreeNode current = q.peek();
                addNeighbors(current, q);
                q.remove();
            }
        }
        return sum;
    }
    public static int addUpElementsInQueue(Queue < TreeNode > q) {
        int sum = 0;
        for (TreeNode node: q) {
            sum += node.val;
        }
        return sum;
    }
    public static void addNeighbors(TreeNode current, Queue < TreeNode > q) {
        if (current.left != null) {
            q.add(current.left);
        }
        if (current.right != null) {
            q.add(current.right);
        }
        return;
    }
}
