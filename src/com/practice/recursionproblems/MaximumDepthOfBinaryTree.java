package com.practice.recursionproblems;

import java.util.ArrayList;
import java.util.List;

/**Problem statement:
 Given the root of a binary tree, return its maximum depth.

 A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest
 leaf node.

 Leetcode link: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 **/

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.right == null && root.left == null){
            return 1;
        }
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        return Math.max(left, right);

    }
}
