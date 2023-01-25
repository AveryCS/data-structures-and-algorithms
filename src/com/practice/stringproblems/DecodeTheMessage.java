package com.practice.stringproblems;
import java.util.*;
/**Problem statement:
 You are given the strings key and message, which represent a cipher key and a secret message, respectively. The steps to decode message are as follows:

 Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
 Align the substitution table with the regular English alphabet.
 Each letter in message is then substituted using the table.
 Spaces ' ' are transformed to themselves.
 For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet), we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
 Return the decoded message.

 Example 1:
 Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
 Output: "this is a secret"
 Explanation: The diagram above shows the substitution table.
 It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog".

 Leetcode link: https://leetcode.com/problems/decode-the-message/description/
 **/
public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {

        Map < Character, Character > map = new HashMap < > ();
        putInMap(map, key);
        StringBuilder result = new StringBuilder();

        for (int j = 0; j < message.length(); j++) {
            char check = message.charAt(j);
            if (check == ' ') {
                result.append(" ");
            } else {
                result.append(map.get(check));
            }
        }
        return result.toString();
    }
    public static void putInMap(Map < Character, Character > map, String key) {
        char alphabet = 'a';
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) != ' ' && !map.containsKey(key.charAt(i))) {
                map.put(key.charAt(i), alphabet);
                alphabet++;
            }
        }

    }
}