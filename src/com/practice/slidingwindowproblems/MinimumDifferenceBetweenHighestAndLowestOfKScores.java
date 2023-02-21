package com.practice.slidingwindowproblems;
import java.util.*;
/**Problem statement:
 You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.

 Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.

 Return the minimum possible difference.
 Example 1:

 Input: nums = [9,4,1,7], k = 2
 Output: 2
 Explanation: There are six ways to pick score(s) of two students:
 - [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 = 5.
 - [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 = 8.
 - [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 = 2.
 - [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 = 3.
 - [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 = 3.
 - [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 = 6.
 The minimum possible difference is 2.

 Constraints:
 1 <= k <= nums.length <= 1000
 0 <= nums[i] <= 105
 Leetcode link: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
 **/

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {

        if(nums.length<2){
            return 0;
        }
        Arrays.sort(nums);

        int minDiff= Integer.MAX_VALUE;

        for( int p1=0, p2=p1+(k-1); p2< nums.length; p1++, p2++){
            minDiff=Math.min(minDiff, nums[p2]-nums[p1]);
        }
        return minDiff;
    }
}
