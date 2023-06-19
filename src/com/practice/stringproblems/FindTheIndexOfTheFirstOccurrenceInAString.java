package com.practice.stringproblems;
import java.util.*;
/**Problem statement:
 Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 Example 1:
 Input: haystack = "sadbutsad", needle = "sad"
 Output: 0
 Explanation: "sad" occurs at index 0 and 6.
 The first occurrence is at index 0, so we return 0.

 Example 2:
 Input: haystack = "leetcode", needle = "leeto"
 Output: -1
 Explanation: "leeto" did not occur in "leetcode", so we return -1.


 Constraints:
 1 <= haystack.length, needle.length <= 104
 haystack and needle consist of only lowercase English characters.
 Leetcode link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 **/
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int stop = haystack.length() - needle.length()+1;

        for(int i = 0; i< stop; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(matches(haystack, needle, i)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean matches( String haystack, String needle, int index){
        for(int i = index, j=0; j< needle.length(); index++, j++){
            if(haystack.charAt(index) != needle.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
