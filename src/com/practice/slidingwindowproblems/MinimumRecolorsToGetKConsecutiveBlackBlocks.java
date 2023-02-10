package com.practice.slidingwindowproblems;
import java.util.*;
/**Problem statement:
 You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.

 You are also given an integer k, which is the desired number of consecutive black blocks.

 In one operation, you can recolor a white block such that it becomes a black block.

 Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.



 Example 1:

 Input: blocks = "WBBWWBBWBW", k = 7
 Output: 3
 Explanation:
 One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
 so that blocks = "BBBBBBBWBW".
 It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
 Therefore, we return 3.
 Example 2:

 Input: blocks = "WBWBBBW", k = 2
 Output: 0
 Explanation:
 No changes need to be made, since 2 consecutive black blocks already exist.
 Therefore, we return 0.

 Leetcode link: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
 **/

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        if (meetsCriteria(blocks, k)) {
            return 0;
        } else {
            char[] arr = blocks.toCharArray();
            int changeCount = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                int bCount = 0;
                int tempChangeCount = 0;
                for (int i = j; i < arr.length; i++) {
                    if (blocks.charAt(i) == 'W') {
                        bCount++;
                        tempChangeCount++;
                    } else {
                        bCount++;
                    }
                    if (bCount == k) {
                        changeCount = Math.min(changeCount, tempChangeCount);
                    }

                }
            }
            return changeCount;
        }

    }
    public static boolean meetsCriteria(String blocks, int k) {
        int count = 0;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'E') {
                count++;
            } else if (blocks.charAt(i) == 'W') {
                count = 0;
            }
            if (count >= k) {
                return true;
            }
        }
        return false;
    }
}
