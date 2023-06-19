package com.practice.stringproblems;
import java.util.*;
/**Problem statement:
 A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

 Given a string s, return true if it is a palindrome, or false otherwise.
 Example 1:
 Input: s = "A man, a plan, a canal: Panama"
 Output: true
 Explanation: "amanaplanacanalpanama" is a palindrome.

 Example 2:
 Input: s = "race a car"
 Output: false
 Explanation: "raceacar" is not a palindrome.

 Example 3:
 Input: s = " "
 Output: true
 Explanation: s is an empty string "" after removing non-alphanumeric characters.
 Since an empty string reads the same forward and backward, it is a palindrome.

 Constraints:
 1 <= s.length <= 2 * 105
 s consists only of printable ASCII characters.
 Leetcode link: https://leetcode.com/problems/valid-palindrome/description/
 **/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            char front = s.charAt(begin);
            char back = s.charAt(end);
            if (!isAlphanumeric(front)) {
                begin++;
            }
            if (!isAlphanumeric(back)) {
                end--;
            }
            if (isAlphanumeric(front) && isAlphanumeric(back)) {
                if (!String.valueOf(front).toLowerCase().equals(String.valueOf(back).toLowerCase())) {
                    return false;
                } else {
                    begin++;
                    end--;
                }
            }
        }
        return true;
    }
    public static boolean isAlphanumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}
