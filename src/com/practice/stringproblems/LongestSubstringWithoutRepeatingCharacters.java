package com.practice.stringproblems;
import java.util.*;

/**Problem statement:
 Given a string s, find the length of the longest
 substring
 without repeating characters.

 Example 1:
 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.

 Example 2:
 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.

 Example 3:
 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 Constraints:

 0 <= s.length <= 5 * 104
 s consists of English letters, digits, symbols and spaces.
 Leetcode link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int result = Integer.MIN_VALUE;
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        //LinkedHashSet maintains order
        Set < Character > set = new LinkedHashSet < > ();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!set.contains(letter)) {
                set.add(letter);
            } else {
                removeDuplicateLetterAndEverythingBeforeIt(set, letter);
                set.add(letter);
            }

        }
        return result;
    }
    public static char returnLastCharInSet(Set < Character > set) {
        char lastChar = ' ';
        for (Character c: set) {
            lastChar = c;
        }
        return lastChar;
    }
    public static void removeDuplicateLetterAndEverythingBeforeIt(Set < Character > set, char duplicateLetter) {
        List < Character > setList = new ArrayList < > (set);
        while (setList.get(0) != duplicateLetter) {
            setList.remove(0);
        }
        setList.remove(0);
        set.clear();
        for (Character c: setList) {
            set.add(c);
        }
    }
}
