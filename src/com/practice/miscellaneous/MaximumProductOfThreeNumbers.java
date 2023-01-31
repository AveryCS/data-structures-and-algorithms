package com.practice.miscellaneous;

import java.util.*;
/**Problem statement:
 Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

 Example 1:

 Input: nums = [1,2,3]
 Output: 6
 Example 2:

 Input: nums = [1,2,3,4]
 Output: 24
 Example 3:

 Input: nums = [-1,-2,-3]
 Output: -6

 Leetcode link: https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 **/
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int endOfArray = nums[nums.length-1]* nums[nums.length-2]* nums[nums.length-3];

        int begOfArray = nums[0] * nums[1]* nums[nums.length-1];

        return  Math.max(endOfArray, begOfArray);


    }
}
