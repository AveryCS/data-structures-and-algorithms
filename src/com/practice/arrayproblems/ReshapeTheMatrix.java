package com.practice.arrayproblems;
import java.util.*;
/**Problem statement:
 In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

 You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

 The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

 If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

 Example 1:
 Input: mat = [[1,2],[3,4]], r = 1, c = 4
 Output: [[1,2,3,4]]

 Example 2:
 Input: mat = [[1,2],[3,4]], r = 2, c = 4
 Output: [[1,2],[3,4]]

 Constraints:
 m == mat.length
 n == mat[i].length
 1 <= m, n <= 100
 -1000 <= mat[i][j] <= 1000
 1 <= r, c <= 300
 Leetcode link: https://leetcode.com/problems/reshape-the-matrix/description/
 **/
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] result = new int[r][c];

        int resultWidth = result[0].length;
        int resultHeight = result.length;

        int matWidth = mat[0].length;
        int matHeight = mat.length;

        if (resultWidth * resultHeight != matWidth * matHeight) {
            return mat;
        }
        Queue < Integer > q = new ArrayDeque < > ();
        for (int row = 0; row < matHeight; row++) {
            for (int col = 0; col < matWidth; col++) {
                q.add(mat[row][col]);
            }
        }
        for (int row = 0; row < resultHeight; row++) {
            for (int col = 0; col < resultWidth; col++) {
                result[row][col] = q.remove();
            }
        }
        return result;
    }
}
