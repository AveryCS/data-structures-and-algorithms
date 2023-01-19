package com.practice.stringproblems;

import java.util.*;
/**Problem statement:
 Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.

 Leetcode link: https://leetcode.com/problems/remove-vowels-from-a-string/description/
 **/

public class RemoveVowelsFromAString {
    public String removeVowels(String s) {
        char [] arr = s.toCharArray();
        String result = "";
        for( char c : arr){
            if( ! isVowel(c)){
                result += String.valueOf(c);
            }
        }
        return result;
    }
    public static boolean isVowel(char c){
        return c =='a' || c =='e'|| c == 'i'|| c == 'o' || c == 'u';
    }
}
