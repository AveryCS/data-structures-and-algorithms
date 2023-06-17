package com.practice.hashmapproblems;
import java.util.*;
/**Problem statement:
 Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 Example 1:
 Input: s = "anagram", t = "nagaram"
 Output: true

 Example 2:
 Input: s = "rat", t = "car"
 Output: false

 Constraints:
 1 <= s.length, t.length <= 5 * 104
 s and t consist of lowercase English letters.

 Leetcode link: https://leetcode.com/problems/valid-anagram/description/
 **/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map < Character, Integer > map = new HashMap < > ();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                map.put(letter, map.get(letter) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                map.put(letter, map.get(letter) - 1);
            }
        }

        for (Map.Entry < Character, Integer > k: map.entrySet()) {
            if (k.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
