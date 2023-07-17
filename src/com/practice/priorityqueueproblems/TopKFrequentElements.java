package com.practice.priorityqueueproblems;
import java.util.*;
/**Problem statement:
 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 Example 1:
 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]

 Example 2:
 Input: nums = [1], k = 1
 Output: [1]

 Constraints:
 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 k is in the range [1, the number of unique elements in the array].
 It is guaranteed that the answer is unique.
 Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 Leetcode link: https://leetcode.com/problems/top-k-frequent-elements/
 **/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int pointer = 0;

        Map < Integer, Integer > map = createMap(nums);
        List < Integer > frequencyList = findTopFrequencies(map, k);

        for (Map.Entry < Integer, Integer > f: map.entrySet()) {
            if (frequencyList.contains(f.getValue())) {
                result[pointer] = f.getKey();
                pointer++;
            }
        }
        return result;
    }
    public static List < Integer > findTopFrequencies(Map < Integer, Integer > map, int k) {
        List < Integer > result = new ArrayList < > ();

        Queue < Integer > q = new PriorityQueue < > (Collections.reverseOrder());
        for (Map.Entry < Integer, Integer > l: map.entrySet()) {
            q.add(l.getValue());
        }
        while (k > 0) {
            result.add(q.remove());
            k--;
        }
        return result;
    }
    public static Map < Integer, Integer > createMap(int[] nums) {
        Map < Integer, Integer > map = new HashMap < > ();

        for (int i: nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        return map;

    }
}
