package com.practice.stringproblems;
import java.util.*;
/**Problem statement:
 A string is good if there are no repeated characters.

 Given a string s, return the number of good substrings of length three in s.

 Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

 A substring is a contiguous sequence of characters in a string.

 Example 1:

 Input: s = "xyzzaz"
 Output: 1
 Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
 The only good substring of length 3 is "xyz".

 Leetcode link: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
 **/
public class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int count =0;
        for( int i =0; i< s.length()-2; i++){
            String check = s.substring(i, i+3);
            Set<Character> set = new HashSet<>();
            for(char c: check.toCharArray()){
                set.add(c);
            }
            if(set.size() == 3){
                count ++;
            }
        }
        return count;
    }
}
