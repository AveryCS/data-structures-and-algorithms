package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 You are given an integer array coins representing coins of different denominations and an integer amount
 representing a total amount of money.

 Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made
 up by any combination of the coins, return -1.

 You may assume that you have an infinite number of each kind of coin.

 Example 1:

 Input: coins = [1,2,5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 Example 3:

 Input: coins = [1], amount = 0
 Output: 0

 Leetcode link: https://leetcode.com/problems/coin-change/description/
 **/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        return coinChanger(coins, amount, map);
    }

    public static int coinChanger(int[] coins, int amount, Map<Integer, Integer> map) {
        int minCoins = Integer.MAX_VALUE;
        if (map.containsKey(amount)) {
            return map.get(amount);
        } else if (amount < 0) {
            return -1;
        } else if (amount == 0) {
            return 0;
        } else {

            for (int i = 0; i < coins.length; i++) {
                int coinsNeeded = coinChanger(coins, amount - coins[i], map);
                if (coinsNeeded != -1 && coinsNeeded < minCoins) {
                    minCoins = coinsNeeded + 1;
                }
            }
            int result = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
            map.put(amount, result);
            return result;
        }
    }
}
