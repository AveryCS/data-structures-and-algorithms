package com.practice.recursionproblems;
import java.util.ArrayList;
import java.util.List;

/**Problem statement:
 Given the root of a binary tree, return the inorder traversal of its nodes' values.

 Leetcode link: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 **/

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        if( root == null){
            //this will return an empty list
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        /**the if statement below is not needed. However, it makes the code more clear, but it can be commented out for
         * less time complexity
        **/
          if(root.left == null && root.right == null){
            result.add(root.val);
         }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
}
