package com.practice.miscellaneous;
import java.util.*;
/**Problem statement:
 Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2,2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [4,9]
 Explanation: [9,4] is also accepted.

 Constraints:

 1 <= nums1.length, nums2.length <= 1000
 0 <= nums1[i], nums2[i] <= 1000

 Leetcode link: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/?envType=study-plan&id=data-structure-i
 **/
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map < Integer, Integer > map = new HashMap < > ();
        for (int integer: nums1) {
            if (!map.containsKey(integer)) {
                map.put(integer, 1);
            } else {
                map.put(integer, map.get(integer) + 1);
            }
        }
        List < Integer > numberList = new ArrayList < > ();

        for (int integerTwo: nums2) {
            if (map.containsKey(integerTwo) && map.get(integerTwo) > 0) {
                numberList.add(integerTwo);
                map.put(integerTwo, map.get(integerTwo) - 1);
            }
        }

        int[] result = new int[numberList.size()];
        int index = 0;
        for (Integer k: numberList) {
            result[index] = k;
            index++;
            System.out.println("index is:" + index);
        }
        return result;
    }
}
