package com.practice.priorityqueueproblems;
import java.util.*;
/**Problem statement:
 Given an array of integers nums, sort the array in ascending order and return it.

 You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 Example 1:

 Input: nums = [5,2,3,1]
 Output: [1,2,3,5]
 Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).

 Example 2:
 Input: nums = [5,1,1,2,0,0]
 Output: [0,0,1,1,2,5]
 Explanation: Note that the values of nums are not necessairly unique.

 Constraints:
 1 <= nums.length <= 5 * 104
 -5 * 104 <= nums[i] <= 5 * 104

 Leetcode link: https://leetcode.com/problems/sort-an-array/description/
 **/
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        int[] result = new int[nums.length];
        Queue <Integer> q = new PriorityQueue < > ();
        for (int i: nums) {
            q.add(i);
        }
        int p1 = 0;
        while (!q.isEmpty()) {
            result[p1] = q.remove();
            p1++;
        }
        return result;
    }
}
