package com.practice.recursionproblems;
/**Problem statement:
 Given the root of a binary tree, return the sum of all left leaves.

 A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

 Example 1:
 Input: root = [3,9,20,null,null,15,7]
 Output: 24
 Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.

 Example 2:
 Input: root = [1]
 Output: 0
 Constraints:

 The number of nodes in the tree is in the range [1, 1000].
 -1000 <= Node.val <= 1000

 Leetcode link: https://leetcode.com/problems/sum-of-left-leaves/description/
 **/
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeft(root);
    }
    
    public static int sumLeft(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return sumLeft(root.right);
        }

        int left = sumLeft(root.left);
        int right = sumLeft(root.right);

        if (root.left.left == null && root.left.right == null) {
            return root.left.val + right + left;
        } else {
            return right + left;
        }

    }
}
