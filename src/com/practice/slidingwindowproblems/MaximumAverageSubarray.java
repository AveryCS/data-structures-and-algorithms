package com.practice.slidingwindowproblems;

import java.util.*;
/**Problem statement:
 You are given an integer array nums consisting of n elements, and an integer k.

 Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 Example 1:
 Input: nums = [1,12,-5,-6,50,3], k = 4
 Output: 12.75000
 Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 Example 2:

 Input: nums = [5], k = 1
 Output: 5.00000
 Constraints:
 n == nums.length
 1 <= k <= n <= 105
 -104 <= nums[i] <= 104

 Leetcode link: https://leetcode.com/problems/maximum-average-subarray-i/description/
 **/

public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double avg =0;
        for(int i =0; i< k; i++){
            avg+= nums[i];
        }
        double temp= avg;
        for(int p1=1;p1+ (k-1)< nums.length ; p1++){
            temp -= nums[p1-1];
            temp += nums [p1+(k-1)];
            avg = Math.max(temp, avg);
        }
        return avg/k;
    }
}
