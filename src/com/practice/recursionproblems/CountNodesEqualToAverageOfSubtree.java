package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

 Note:

 The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
 A subtree of root is a tree consisting of root and all of its descendants.


 Example 1:
 Input: root = [4,8,5,0,1,null,6]
 Output: 5
 Explanation:
 For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
 For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
 For the node with value 0: The average of its subtree is 0 / 1 = 0.
 For the node with value 1: The average of its subtree is 1 / 1 = 1.
 For the node with value 6: The average of its subtree is 6 / 1 = 6.

 Example 2:
 Input: root = [1]
 Output: 1
 Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.

 Constraints:
 The number of nodes in the tree is in the range [1, 1000].
 0 <= Node.val <= 1000

 Leetcode link: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 **/

public class CountNodesEqualToAverageOfSubtree {
    int count;
    int sum;
    public int averageOfSubtree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int count = findCount(root);
        int sum = findSum(root);
        int average = (int) Math.floor(sum / count);
        int result = averageOfSubtree(root.left) + averageOfSubtree(root.right);

        return average == root.val ? 1 + result : result;
    }
    public static int findCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + findCount(root.left) + findCount(root.right);
    }
    public static int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + findSum(root.left) + findSum(root.right);

    }
}
