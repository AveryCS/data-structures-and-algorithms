package com.practice.recursionproblems;
import java.io.*;
import java.util.*;
/**Problem statement:
 Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value
 sequence.

 For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

 Two binary trees are considered leaf-similar if their leaf value sequence is the same.

 Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 Constraints:

 The number of nodes in each tree will be in the range [1, 200].
 Both of the given trees will have values in the range [0, 200].

        Leetcode link: https://leetcode.com/problems/leaf-similar-trees/description/
        **/

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return leafSimilar(root2).equals(leafSimilar(root1));
    }

    public static List<Integer> leafSimilar(TreeNode root) {
        List<Integer> oneList = new ArrayList<>();
        if(root == null ){
            return oneList;
        }
        if(root.left == null && root.right == null){
            oneList.add(root.val);
            return oneList;
        }
        oneList.addAll(leafSimilar(root.left));
        oneList.addAll(leafSimilar(root.right));
        return oneList;
    }
}
