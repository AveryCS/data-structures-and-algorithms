package com.practice.arrayproblems;
import java.util.*;
/**Problem statement:
 Write a function that reverses a string. The input string is given as an array of characters s.

 You must do this by modifying the input array in-place with O(1) extra memory.

 Example 1:
 Input: s = ["h","e","l","l","o"]
 Output: ["o","l","l","e","h"]
 Example 2:

 Input: s = ["H","a","n","n","a","h"]
 Output: ["h","a","n","n","a","H"]
 Leetcode link: https://leetcode.com/problems/reverse-string/description/
 **/
public class ReverseString {
    public void reverseString(char[] s) {
        for(int end =s.length-1, begin=0; end>begin; end--, begin++){
            char temp = s[end];
            s[end]= s[begin];
            s[begin]= temp;
        }
    }
}
