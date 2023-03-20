package com.practice.recursionproblems;
/**Problem statement:
 * A recursive solution is not optimal. However, in order to practice recursiion, I have decided to solve this problem recursively.
 *
 Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

 A string is represented by an array if the array elements concatenated in order forms the string.

 Example 1:

 Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 Output: true
 Explanation:
 word1 represents string "ab" + "c" -> "abc"
 word2 represents string "a" + "bc" -> "abc"
 The strings are the same, so return true.
 Example 2:

 Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 Output: false
 Example 3:

 Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 Output: true
 Constraints:

 1 <= word1.length, word2.length <= 103
 1 <= word1[i].length, word2[i].length <= 103
 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 word1[i] and word2[i] consist of lowercase letters.

 Leetcode link: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
 **/
public class CheckIfTwoStringArraysAreEquivalentRecursively {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String one = createString(word1, 0);
        String two = createString(word2, 0);

        return one.equals(two);
    }
    public static String createString(String[] word, int index) {
        StringBuilder result = new StringBuilder();

        if (index == word.length) {
            return result.toString();
        }
        return result.append(word[index]) + createString(word, index + 1);
    }
}
