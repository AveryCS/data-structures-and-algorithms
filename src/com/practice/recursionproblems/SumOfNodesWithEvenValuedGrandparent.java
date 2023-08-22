package com.practice.recursionproblems;
import java.util.*;

/**Problem statement:
 Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.

 A grandparent of a node is the parent of its parent if it exists.
 Example 1:
 Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 Output: 18
 Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

 Example 2:
 Input: root = [1]
 Output: 0

 Constraints:
 The number of nodes in the tree is in the range [1, 104].
 1 <= Node.val <= 100

 Leetcode link: https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 **/


public class SumOfNodesWithEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if(root.val % 2 == 0 ){
            if (root.left != null) {
                sum += sumAllChildrenOfNode(root.left);
            }
            if (root.right != null) {
                sum += sumAllChildrenOfNode(root.right);
            }
        }
        int result = sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
        return  sum + result ;
    }

    public static int sumAllChildrenOfNode(TreeNode root) {
        int sum = 0;
        if (root.left != null) {
            sum += root.left.val;
        }
        if (root.right != null) {
            sum += root.right.val;
        }
        return sum;
    }
}
