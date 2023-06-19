package com.practice.stringproblems;
import java.util.*;
/**Problem statement:
 Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

 Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 Example 1:
 Input: s = "abccccdd"
 Output: 7
 Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

 Example 2:
 Input: s = "a"
 Output: 1
 Explanation: The longest palindrome that can be built is "a", whose length is 1.

 Constraints:
 1 <= s.length <= 2000
 s consists of lowercase and/or uppercase English letters only.
 Leetcode link: https://leetcode.com/problems/longest-palindrome/description/
 **/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Set < Character > set = new HashSet < > ();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        return set.size() > 0 ? (count * 2) + 1 : count * 2;
    }
}
