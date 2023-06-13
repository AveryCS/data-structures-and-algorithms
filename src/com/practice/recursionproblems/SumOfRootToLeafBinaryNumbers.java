package com.practice.recursionproblems;
import java.util.*;

/**Problem statement:
 Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

 Specifically, ans is the concatenation of two nums arrays.

 Return the array ans.
 Example 1:

 Input: nums = [1,2,1]
 Output: [1,2,1,1,2,1]
 Explanation: The array ans is formed as follows:
 - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 - ans = [1,2,1,1,2,1]
 Example 2:

 Input: nums = [1,3,2,1]
 Output: [1,3,2,1,1,3,2,1]
 Explanation: The array ans is formed as follows:
 - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
 - ans = [1,3,2,1,1,3,2,1]


 Constraints:
 n == nums.length
 1 <= n <= 1000
 1 <= nums[i] <= 1000

 Leetcode link: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/
 **/
public class SumOfRootToLeafBinaryNumbers {
    List < String > binaryList = new ArrayList < > ();
    public int sumRootToLeaf(TreeNode root) {

        addToList(root, "");
        int sum = 0;
        for (String s: binaryList) {
            int temp = Integer.parseInt(s, 2);
            sum += temp;
        }
        return sum;
    }
    public void addToList(TreeNode root, String number) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            number = number + String.valueOf(root.val);
            binaryList.add(number);
            return;
        }
        number = number + String.valueOf(root.val);
        addToList(root.left, number);
        addToList(root.right, number);
    }
}

