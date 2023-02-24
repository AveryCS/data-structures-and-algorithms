package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

 F(0) = 0, F(1) = 1
 F(n) = F(n - 1) + F(n - 2), for n > 1.
 Given n, calculate F(n).

 Example 1:

 Input: n = 2
 Output: 1
 Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

 Constraints:

 0 <= n <= 30
 Leetcode link: https://leetcode.com/problems/fibonacci-number/description/
 **/
public class FibonacciNumber {
    public int fib(int n) {


        if(n == 0 || n==1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}
