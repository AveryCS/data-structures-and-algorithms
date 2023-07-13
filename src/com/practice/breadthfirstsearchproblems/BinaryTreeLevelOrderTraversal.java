package com.practice.breadthfirstsearchproblems;

import java.util.*;
/**Problem statement:
 Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 Example 1:
 Input: root = [3,9,20,null,null,15,7]
 Output: [[3],[9,20],[15,7]]

 Example 2:
 Input: root = [1]
 Output: [[1]]
 Example 3:

 Input: root = []
 Output: []

 Constraints:
 The number of nodes in the tree is in the range [0, 2000].
 -1000 <= Node.val <= 1000

 Leetcode link: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 **/
public class BinaryTreeLevelOrderTraversal {
    public List < List < Integer >> levelOrder(TreeNode root) {

        Queue < TreeNode > q = new ArrayDeque < > ();
        int size = q.size();
        List < List < Integer >> result = new ArrayList < > ();
        if (root == null) {
            return result;
        }
        result.add(List.of(root.val));
        q.add(root);
        while (!q.isEmpty()) {
            size = q.size();
            List < Integer > neighborList = new ArrayList < > ();
            for (int i = 0; i < size; i++) {
                for (Integer k: findNeighborsAndAddToQueue(q.peek(), q)) {
                    neighborList.add(k);
                }
                q.remove();
            }
            if (!neighborList.isEmpty()) {
                result.add(neighborList);
            }
        }
        return result;
    }
    public static List < Integer > findNeighborsAndAddToQueue(TreeNode root, Queue < TreeNode > q) {
        List < Integer > neighborList = new ArrayList < > ();
        if (root.left != null) {
            neighborList.add(root.left.val);

            q.add(root.left);
        }
        if (root.right != null) {
            neighborList.add(root.right.val);

            q.add(root.right);
        }
        return neighborList;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }