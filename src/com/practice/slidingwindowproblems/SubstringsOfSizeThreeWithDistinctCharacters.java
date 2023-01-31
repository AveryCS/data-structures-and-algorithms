package com.practice.slidingwindowproblems;
import java.util.*;
/**Problem statement:
 A string is good if there are no repeated characters.

 Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

 Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

 A substring is a contiguous sequence of characters in a string.
 Example 1:

 Input: s = "xyzzaz"
 Output: 1
 Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
 The only good substring of length 3 is "xyz".
 Example 2:

 Input: s = "aababcabc"
 Output: 4
 Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
 The good substrings are "abc", "bca", "cab", and "abc".

 Leetcode link: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
 **/
public class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int count =0;
        char [] arr = s.toCharArray();

        for( int i=0; i<= arr.length -3; i++){
            if( isGood(i,arr) ){
                count ++;
            }
        }
        return count;
    }
    public static boolean isGood( int i, char [] arr){
        return arr[i] != arr[i+1] && arr[i+1] != arr[i+2] && arr[i] != arr[i+2];
    }
}
