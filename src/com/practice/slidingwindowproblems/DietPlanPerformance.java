package com.practice.slidingwindowproblems;
import java.util.*;
/**Problem statement:
 A dieter consumes calories[i] calories on the i-th day.
 Given an integer k, for every consecutive sequence of k days (calories[i], calories[i+1], ..., calories[i+k-1] for all 0 <= i <= n-k), they look at T, the total calories consumed during that sequence of k days (calories[i] + calories[i+1] + ... + calories[i+k-1]):

 If T < lower, they performed poorly on their diet and lose 1 point;
 If T > upper, they performed well on their diet and gain 1 point;
 Otherwise, they performed normally and there is no change in points.
 Initially, the dieter has zero points. Return the total number of points the dieter has after dieting for calories.length days.

 Note that the total points can be negative.

 Example 1:

 Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
 Output: 0
 Explanation: Since k = 1, we consider each element of the array separately and compare it to lower and upper.
 calories[0] and calories[1] are less than lower so 2 points are lost.
 calories[3] and calories[4] are greater than upper so 2 points are gained.

 Leetcode link: https://leetcode.com/problems/diet-plan-performance/description/
 **/
public class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int total =0;
        int totalPoints =0;

        for(int i=0; i< k; i++){
            total+= calories[i];
        }
        if( total< lower){
            totalPoints--;
        }
        else if(total> upper){
            totalPoints++;
        }
        for(int p1=1, p2 =p1 +(k-1); p2< calories.length; p1++, p2++){

            total-= calories[p1-1];
            total+= calories[p2];
            if( total< lower){
                totalPoints--;
            }
            else if(total> upper){
                totalPoints++;
            }
        }
        return totalPoints;
    }
}
