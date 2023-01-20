package com.practice.stringproblems;

import java.util.*;
/**Problem statement:
 You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

 Return the shuffled string.

 Example 1:
 Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 Output: "leetcode"
 Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.

 Leetcode link:https://leetcode.com/problems/shuffle-string/description/
 **/
public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        Map<Integer, Character> map = new HashMap<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            map.put(indices[i], arr[i]);
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            result.append(map.get(j));
        }
        return result.toString();
    }
}
