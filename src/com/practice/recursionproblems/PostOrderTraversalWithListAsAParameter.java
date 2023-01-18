package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 Given the root of a binary tree, return the postorder traversal of its nodes' values.

 Leetcode link: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 **/

public class PostOrderTraversalWithListAsAParameter {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    public static void postorderTraversal(TreeNode root, List<Integer> result ){
        if(root == null){
            return;
        }
        postorderTraversal(root.left, result);
        postorderTraversal(root.right,result);
        result.add(root.val);
        return;

    }
}
