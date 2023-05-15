package com.practice.stringproblems;
/**Problem statement:
 *
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with
 * word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.

 * Example 1:

 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 *
 * Constraints:
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.

 Leetcode link: https://leetcode.com/problems/merge-strings-alternately/description/

 **/

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        StringBuilder mergedWord = new StringBuilder();

        while (p1 < word1.length() && p2 < word2.length()) {
            char wordOneLetter = word1.charAt(p1);
            mergedWord.append(wordOneLetter);
            p1++;
            char wordTwoLetter = word2.charAt(p2);
            mergedWord.append(wordTwoLetter);
            p2++;
        }
        if (p1 < word1.length()) {
            for (int i = p1; p1 < word1.length(); p1++) {
                mergedWord.append(word1.charAt(p1));
            }
        }
        if (p2 < word2.length()) {
            for (int i = p2; p2 < word2.length(); p2++) {
                mergedWord.append(word2.charAt(p2));
            }
        }
        return String.valueOf(mergedWord);
    }
}
