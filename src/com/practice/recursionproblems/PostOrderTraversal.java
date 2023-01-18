package com.practice.recursionproblems;
import java.io.*;
import java.util.*;
/**Problem statement:
 Given the root of a binary tree, return the postorder traversal of its nodes' values.

 Leetcode link: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 **/
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);

        return result;

    }
}
