package com.practice.recursionproblems;

import java.io.*;
import java.util.*;
/**Problem statement:
 Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

 Constraints:

 The number of nodes in the tree is in the range [1, 104].
 -104 <= Node.val <= 104
 root is guaranteed to be a valid binary search tree.
 -105 <= k <= 105
 Leetcode https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 **/

public class TwoSumIVInputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> result = findTargets(root,k);
        for(Integer l: result){
            System.out.println(l);
        }

        for( int i = 0, j = result.size()-1 ; i<result.size() && j>-1 && i<j  ; ){
            int sum =result.get(i) + result.get(j);
            if( sum == k){
                return true;
            }if(sum < k){
                i++;
            }
            if(sum > k){
                j--;
            }
        }
        return false;
    }
    public List<Integer> findTargets(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        result.addAll(findTargets(root.left,k));
        result.add(root.val);
        result.addAll( findTargets( root.right, k));
        return result;
    }
}
