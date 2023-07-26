package com.practice.priorityqueueproblems;
import java.util.*;
/**Problem statement:
 Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 You must find a solution with a memory complexity better than O(n2).

 Example 1:
 Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 Output: 13
 Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

 Example 2:
 Input: matrix = [[-5]], k = 1
 Output: -5
 Constraints:

 n == matrix.length == matrix[i].length
 1 <= n <= 300
 -109 <= matrix[i][j] <= 109
 All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
 1 <= k <= n2

 Leetcode link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 **/
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {

        Queue < Integer > q = new PriorityQueue < > ();
        putElementsInPriorityQueue(q, matrix);

        int result = 0;
        int count = 0;

        while (!q.isEmpty() && count < k) {
            result = q.remove();
            count++;
        }
        return result;
    }
    public static void putElementsInPriorityQueue(Queue < Integer > q, int[][] matrix) {
        for (int[] singleArr: matrix) {
            for (int number: singleArr) {
                q.add(number);
            }
        }
    }
}
