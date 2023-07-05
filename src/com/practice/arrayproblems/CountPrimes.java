package com.practice.arrayproblems;
import java.util.*;
/**Problem statement:
 Given an integer n, return the number of prime numbers that are strictly less than n.
 Example 1:
 Input: n = 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 Example 2:
 Input: n = 0
 Output: 0
 Example 3:

 Input: n = 1
 Output: 0
 Constraints:

 0 <= n <= 5 * 106

 **Helpful hint: Look up Sieves of Eratosthenes
 **/
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = createFilledOutArray(n);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
    public static boolean[] createFilledOutArray(int number) {
        boolean[] isPrime = new boolean[number];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (isPrime[i]) {
                int j = i + i;
                while (j < number) {
                    isPrime[j] = false;
                    j += i;
                }
            }
        }
        return isPrime;
    }
}
