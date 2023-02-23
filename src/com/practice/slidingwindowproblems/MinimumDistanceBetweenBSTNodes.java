package com.practice.slidingwindowproblems;
import java.util.*;
/**Problem statement:
 Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different
 nodes in the tree.

 Input: root = [4,2,6,1,3]
 Output: 1

 Constraints:

 The number of nodes in the tree is in the range [2, 100].
 0 <= Node.val <= 105

 Leetcode link: https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 **/
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        List < Integer > list = new ArrayList < > ();
        createList(root, list);

        int temp = Math.abs(list.get(0) - list.get(1));
        int result = temp;
        for (int i = 1; i < list.size() - 1; i++) {
            temp = Math.abs(list.get(i) - list.get(i + 1));
            result = Math.min(temp, result);
        }
        return result;
    }

    public static void createList(TreeNode root, List < Integer > list) {
        if (root == null) {
            return;
        }
        createList(root.left, list);
        list.add(root.val);
        createList(root.right, list);
        return;
    }
}
