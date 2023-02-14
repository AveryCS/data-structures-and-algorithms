package com.practice.stackproblems;
import java.util.*;
/**Problem statement:
 Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 Example 1:
 Input: temperatures = [73,74,75,71,69,72,76,73]
 Output: [1,1,4,2,1,1,0,0]
 Example 2:
 Input: temperatures = [30,60,90]
 Output: [1,1,0]
 Constraints:
 1 <= temperatures.length <= 105
 30 <= temperatures[i] <= 100

 Leetcode link: https://leetcode.com/problems/daily-temperatures/description/
 **/

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack < Integer > stack = new Stack < > ();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int index = stack.pop();
                int diff = i - index;
                result[index] = diff;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;

    }
}
