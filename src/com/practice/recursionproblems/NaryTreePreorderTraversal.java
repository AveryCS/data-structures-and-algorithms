package com.practice.recursionproblems;
import java.util.ArrayList;
import java.util.List;

/**Problem statement:
 Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

 Nary-Tree input serialization is represented in their level order traversal. Each group of children is
 separated by the null value

 Leetcode link: https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 **/


public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.val);
        //traverse the list of children
        for(Node n: root.children){
            result.addAll(preorder(n));
        }
        return result;
    }
}

//Definition for Node class can be found in "N-ary Tree Post Order Traversal"