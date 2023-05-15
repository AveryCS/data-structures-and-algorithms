package com.practice.stringproblems;
import java.util.*;
/**Problem statement:
 Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 Example 1:

 Input: s = "Hello"
 Output: "hello"
 Example 2:

 Input: s = "here"
 Output: "here"
 Example 3:

 Input: s = "LOVELY"
 Output: "lovely"

 Constraints:
 1 <= s.length <= 100
 s consists of printable ASCII characters.
 Leetcode link: https://leetcode.com/problems/to-lower-case/description/
 **/
public class ToLowerCase {
    public String toLowerCase(String s) {

        StringBuilder result = new StringBuilder();
        char a = 'a';
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letter < a) {
                result.append(String.valueOf(letter).toLowerCase());
            } else {
                result.append(letter);
            }
        }

        return String.valueOf(result);

    }
}
