package com.practice.slidingwindowproblems;
import java.util.*;
/**Problem statement:
 Given an array and value k

 Find the maximum sum in a contiguous window of size k that includes the first element or last element of the array

 input [3,4,2,8,1]
 k = 3
 output: 12

 input: [1,3,3,4]
 k = 2
 output: 7


 **/
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4};
        int k = 2;
        int sum = 0;
        for (int l = 0; l < k; l++) {
            sum += nums[l];
        }
        int tempSum = sum;

        for (int i = 1, j = i + k - 1; i < nums.length; i++, j++) {
            j = j % nums.length;
            tempSum -= nums[i - 1];
            tempSum += nums[j];
            if (includesFirstOrLast(nums, i, j)) {
                sum = Math.max(tempSum, sum);
            }
        }
        System.out.println(sum);
    }
        public static boolean includesFirstOrLast ( int[] nums, int begin, int end){
            return end == 0 || begin == 0 || begin == nums.length || end == nums.length - 1;
        }
}
