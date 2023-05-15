package com.practice.stringproblems;

import java.util.*;
/**Problem statement:
 International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

 'a' maps to ".-",
 'b' maps to "-...",
 'c' maps to "-.-.", and so on.
 For convenience, the full table for the 26 letters of the English alphabet is given below:

 [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

 For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
 Return the number of different transformations among all words we have.

 Example 1:
 Input: words = ["gin","zen","gig","msg"]
 Output: 2
 Explanation: The transformation of each word is:
 "gin" -> "--...-."
 "zen" -> "--...-."
 "gig" -> "--...--."
 "msg" -> "--...--."
 There are 2 different transformations: "--...-." and "--...--.".

 Constraints:
 1 <= words.length <= 100
 1 <= words[i].length <= 12
 words[i] consists of lowercase English letters.
 Leetcode https://leetcode.com/problems/unique-morse-code-words/description/
 **/

public class UniqueMorseCodeWords {
    static String [] morseArr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set < String > wordSet = new HashSet < > ();
        char a = 'a';
        for (String word: words) {
            StringBuilder morseWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                String morseLetter = morseArr[letter - a];
                morseWord.append(morseLetter);
            }
            wordSet.add(String.valueOf(morseWord));
        }
        return wordSet.size();

    }
}
