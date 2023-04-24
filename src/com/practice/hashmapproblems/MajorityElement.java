package com.practice.hashmapproblems;
import java.util.*;
/**Problem statement:
 Given an array nums of size n, return the majority element.

 The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 Example 1:

 Input: nums = [3,2,3]
 Output: 3
 Example 2:

 Input: nums = [2,2,1,1,1,2,2]
 Output: 2

 Constraints:
 n == nums.length
 1 <= n <= 5 * 104
 -109 <= nums[i] <= 109


 Leetcode link: https://leetcode.com/problems/majority-element/description/

 **Special note: This problem can be solved more efficiently using the Moore's Voting algorithm
 **/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int maxCount = Integer.MIN_VALUE;
        Map < Integer, Integer > map = new HashMap < > ();
        int result = 0;

        for (int i: nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
                if (map.get(i) > maxCount) {
                    maxCount = map.get(i);
                    result = i;
                }
            } else {
                int tempCount = map.get(i) + 1;
                map.put(i, tempCount);

                if (tempCount > maxCount) {
                    maxCount = tempCount;
                    result = i;
                }
            }
        }
        return result;
    }
}
