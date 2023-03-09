package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 You are given an m x n integer matrix matrix with the following two properties:

 Each row is sorted in non-decreasing order.
 The first integer of each row is greater than the last integer of the previous row.
 Given an integer target, return true if target is in matrix or false otherwise.

 You must write a solution in O(log(m * n)) time complexity.
 Example 1:
 Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 Output: true

 Leetcode link: https://leetcode.com/problems/search-a-2d-matrix/description/
 **/
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            if (bSearch(0, matrix[0].length, matrix[row], target) == 1) {
                return true;
            }
        }
        return false;
    }
    public static int bSearch(int begin, int end, int[] row, int target) {
        int middle = (begin + end) / 2;

        if (row[middle] == target) {
            return 1;
        }
        if (middle == begin || middle == end) {
            return 0;
        } else if (row[middle] > target) {
            end = middle;
        } else if (row[middle] < target) {
            begin = middle + 1;
        }
        if (middle == row.length || begin == row.length) {
            return 0;
        }
        return bSearch(begin, end, row, target);

    }
}
