package com.practice.arrayproblems;
import java.util.*;
/**Problem statement:
 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 Example 1:
 Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

 Example 2:
 Input: intervals = [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 Constraints:
 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104
 Leetcode link: https://leetcode.com/problems/merge-intervals/
 **/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        List < List < Integer >> list = new ArrayList < > ();
        if (intervals.length <= 1) {
            return intervals;
        }
        int[] currentInterval = intervals[0];
        for (int row = 1; row < intervals.length; row++) {

            if (doesNotOverlap(currentInterval, intervals[row])) {
                list.add(List.of(currentInterval[0], currentInterval[1]));
                currentInterval = intervals[row];
            } else {
                currentInterval = createOverlappingIntervalArray(currentInterval, intervals[row]);
            }
        }
        list.add(List.of(currentInterval[0], currentInterval[1]));
        return putElementsInListInAnArray(list);
    }

    public static int[][] putElementsInListInAnArray(List < List < Integer >> list) {
        int[][] result = new int[list.size()][2];
        int row = 0;
        for (List < Integer > singleList: list) {
            result[row][0] = singleList.get(0);
            result[row][1] = singleList.get(1);
            row++;
        }
        return result;

    }

    public static boolean doesNotOverlap(int[] currentInterval, int[] nextInterval) {
        return currentInterval[1] < nextInterval[0];
    }

    public static int[] createOverlappingIntervalArray(int[] currentInterval, int[] nextInterval) {
        int lowest = Math.min(currentInterval[0], nextInterval[0]);
        int highest = Math.max(currentInterval[1], nextInterval[1]);
        return new int[] {
                lowest,
                highest
        };
    }
}
