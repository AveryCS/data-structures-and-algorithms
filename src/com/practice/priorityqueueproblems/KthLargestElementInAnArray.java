package com.practice.priorityqueueproblems;
import java.util.*;
/**Problem statement:
 Given an integer array nums and an integer k, return the kth largest element in the array.

 Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Can you solve it without sorting?
 Example 1:
 Input: nums = [3,2,1,5,6,4], k = 2
 Output: 5

 Example 2:
 Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 Output: 4

 Constraints:
 1 <= k <= nums.length <= 105
 -104 <= nums[i] <= 104

 Leetcode link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 **/
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for( int i :nums){
            q.add(i);
        }
        int result =0;
        while(k > 0){
            result = q.remove();
            k--;
        }
        return result;

    }
}
