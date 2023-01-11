package com.practice.recursionproblems;

import java.util.ArrayList;
import java.util.List;

/**Problem statement:
 Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

 Nary-Tree input serialization is represented in their level order traversal. Each group
 of children is separated by the null value.

 Leetcode link: https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 **/

public class NaryTreePostorderTraversal {

    public List< Integer > postorder(Node root) {
        List < Integer > result = new ArrayList< >();
        if (root == null) {
            return result;
        }
        for (Node n: root.children) {
            result.addAll(postorder(n));
        }
        result.add(root.val);
        return result;

    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};