package com.practice.stringproblems;

import java.util.*;
/**Problem statement:
 A pangram is a sentence where every letter of the English alphabet appears at least once.

 Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 Example 1:

 Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 Output: true
 Explanation: sentence contains at least one of every letter of the English alphabet.

 Leetcode link: https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 **/

public class CheckIfTheSentenceIsAPangram {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(char s : sentence.toCharArray()){
            set.add(s);
        }
        return set.size() == 26;
    }
}
