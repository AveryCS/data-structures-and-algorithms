package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 Write an algorithm to determine if a number n is happy.

 A happy number is a number defined by the following process:

 Starting with any positive integer, replace the number by the sum of the squares of its digits.
 Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy.
 Return true if n is a happy number, and false if not.

 Example 1:
 Input: n = 19
 Output: true
 Explanation:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1

 Example 2:
 Input: n = 2
 Output: false

 Constraints:
 1 <= n <= 231 - 1

 Leetcode link: https://leetcode.com/problems/happy-number/description/
 **/
public class HappyNumber {
    public boolean isHappy(int n) {
        Set < Integer > set = new HashSet < > ();
        return isHappyHelper(n, set);
    }
    public static boolean isHappyHelper(int n, Set < Integer > set) {
        if (n == 1) {
            return true;
        }
        if (set.contains(n)) {
            return false;
        }
        set.add(n);
        return isHappyHelper(findSum(n), set);
    }
    public static int findSum(int n) {
        int sum = 0;
        String numberString = String.valueOf(n);

        for (int i = 0; i < numberString.length(); i++) {
            int number = Character.getNumericValue(numberString.charAt(i));
            int squaredNumber = (int) Math.pow(number, 2);
            sum += squaredNumber;
        }
        return sum;
    }
}
