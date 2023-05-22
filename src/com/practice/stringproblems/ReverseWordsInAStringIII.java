package com.practice.stringproblems;
import java.util.*;
/**Problem statement:
 *
 Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: s = "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Example 2:

 Input: s = "God Ding"
 Output: "doG gniD"

 Constraints:
 1 <= s.length <= 5 * 104
 s contains printable ASCII characters.
 s does not contain any leading or trailing spaces.
 There is at least one word in s.
 All the words in s are separated by a single space.

 Leetcode link: https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 **/
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] parts = s.split(" ");
        for (String word: parts) {
            System.out.println(word);
            reverseWord(word);
            sb.append(reverseWord(word)).append(" ");
        }
        return String.valueOf(sb).trim();
    }

    public static String reverseWord(String word) {
        StringBuilder singleWord = new StringBuilder();
        for (int i = word.length() - 1; i > -1; i--) {
            singleWord.append(word.charAt(i));
        }
        return String.valueOf(singleWord);
    }
}
