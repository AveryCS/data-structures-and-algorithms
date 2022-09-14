package com.practice.stringproblems;

//Given a string and a non-empty word string, return a string made of each char just before and just after
//        every appearance of the word in the string. Ignore cases where there is no char before or after
//        the word, and a char may be included twice if it is between two words.
//
//
//        wordEnds("abcXY123XYijk", "XY") → "c13i"
//        wordEnds("XY123XY", "XY") → "13"
//        wordEnds("XY1XY", "XY") → "11"
public class String2WordEnds {

    public static void main(String[] args) {
        String str= "abcXY123XYijk";
        String word = "XY";
        String result = wordEnds(str, word);
        System.out.println(result);
    }

    public static String wordEnds(String str, String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= str.length() - word.length(); i++) {
            String check = str.substring(i, i + word.length());
            if (check.equals(word)) {
                if (i > 0) {
                    sb.append(str.charAt(i - 1));
                }
                if (i + word.length() < str.length()) {
                    sb.append(str.charAt(i + word.length()));
                }
            }
        }
        return sb.toString();
    }
}