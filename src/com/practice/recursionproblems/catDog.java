package com.practice.recursionproblems;

/**
 *
 * To practice recursion, I took this simple codingbat problem and implemented it recursively
 * Problem statement:
 *
 Return true if the string "cat" and "dog" appear the same number of times in the given string.
 catDog("catdog") → true
 catDog("catcat") → false
 catDog("1cat1cadodog") → true
 *
Codingbat link: https://codingbat.com/prob/p111624
         **/
public class catDog {
    public boolean catDog(String str) {

        return findCount(str, 0) == 0;

    }

    public static int findCount(String str, int index) {

        if (index > str.length() - 3) {
            return 0;
        }
        String check = str.substring(index, index + 3);

        if (check.equals("dog")) {
            return 1 + findCount(str, index + 1);
        }

        if (check.equals("cat")) {
            return -1 + findCount(str, index + 1);
        } else {
            return findCount(str, index + 1);
        }
    }
}
