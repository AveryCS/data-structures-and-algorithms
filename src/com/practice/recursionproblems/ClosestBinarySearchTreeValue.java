package com.practice.recursionproblems;
import java.util.*;

/**Problem statement:
 Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.

 Example 1:
 Input: root = [4,2,5,1,3], target = 3.714286
 Output: 4

 Example 2:
 Input: root = [1], target = 4.428571
 Output: 1
 Constraints:

 The number of nodes in the tree is in the range [1, 104].
 0 <= Node.val <= 109
 -109 <= target <= 109


 Leetcode link: https://leetcode.com/problems/closest-binary-search-tree-value/description/
 **/
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        double result = Integer.MAX_VALUE;
        int [] finalResult = new int [1];
        findClosest(root,target, result, finalResult);
        return finalResult[0];
    }
    public static void findClosest(TreeNode root, double target, double result, int [] finalResult){
        if(root == null){
            return;
        }
        double temp = Math.abs(target - root.val);
        if(temp == result){
            int current = finalResult[0];
            finalResult[0] = Math.min(current, root.val);
        }
        if(temp < result){
            finalResult[0] = root.val;
        }

        result = Math.min(result, temp);

        if(root.left == null && root.right == null){
            //evaluate root
            return;
        }
        findClosest(root.right, target, result, finalResult);
        findClosest(root.left, target, result, finalResult);

    }
}
