package com.practice.recursionproblems;
import java.io.*;
import java.util.*;
/**Problem statement:
 A binary tree is uni-valued if every node in the tree has the same value.

 Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.

 Constraints:

 The number of nodes in the tree is in the range [1, 100].
 0 <= Node.val < 100

 Leetcode link: https://leetcode.com/problems/univalued-binary-tree/description/
 **/
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {

        return isUnivalTree(root, root.val);
    }
    public boolean isUnivalTree(TreeNode root, int value ) {

        if( root == null){
            return true;
        }

        if( root.val != value ){
            return false;
        }
        boolean left = isUnivalTree(root.left, root.val);
        boolean right =isUnivalTree(root.right, root.val);

        return left && right;
    }
}
