package com.practice.recursionproblems;
/**
 *
 * To practice recursion, I took this simple codingbat problem and implemented it recursively, using tail recursion.
 *
 * Problem statement:
 *
 Return the number of times that the string "hi" appears anywhere in the given string.
 countHi("abc hi ho") → 1
 countHi("ABChi hi") → 2
 countHi("hihi") → 2
 *
 Codingbat link: https://codingbat.com/prob/p147448
 **/
public class countHi {
    public int countHi(String str) {
        return totalHi(str, 0);
    }
    public int totalHi(String str, int index) {
        if (index > str.length() - 2) {
            return 0;
        }

        int count = totalHi(str, index + 1);

        String check = str.substring(index, index + 2);
        if (check.equals("hi")) {
            return 1 + count;
        } else {
            return count;
        }
    }
}
