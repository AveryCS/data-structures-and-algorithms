package com.practice.recursionproblems;

import java.io.*;
import java.util.*;
/**Problem statement:
 Given the root of a binary tree, return the preorder traversal of its nodes' values.

 Leetcode link: https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 **/

public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if( root == null){
            return result;
        }

        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));

        return result;
    }
}
