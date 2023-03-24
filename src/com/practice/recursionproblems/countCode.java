package com.practice.recursionproblems;
/**
 *
 * To practice recursion, I took this simple codingbat problem and implemented it recursively, using recursion.
 *
 * Problem statement:
 *
 Return the number of times that the string "code" appears anywhere in the given string, except we'll accept
 any letter for the 'd', so "cope" and "cooe" count.

 countCode("aaacodebbb") → 1
 countCode("codexxcode") → 2
 countCode("cozexxcope") → 2
 Codingbat link:https://codingbat.com/prob/p123614
 **/
public class countCode {
    public int countCode(String str) {

        return countCodes(str, 0);
    }

    public int countCode(String str, int index) {
        if (index > str.length() - 4) {
            return 0;
        }
        int count = countCode(str, index + 1);

        if (str.substring(index, index + 2).equals("co") && str.charAt(index + 3) == 'e') {
            return 1 + count;
        } else {
            return count;
        }
    }

    public int countCodes(String str, int index) {
        if (index > str.length() - 4) {
            return 0;
        }

        if (str.substring(index, index + 2).equals("co") && str.charAt(index + 3) == 'e') {
            return 1 + countCodes(str, index + 1);
        } else {
            return countCodes(str, index + 1);
        }

    }
}