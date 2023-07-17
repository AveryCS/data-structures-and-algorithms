package com.practice.recursionproblems;
/**Problem statement:
 Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:
 Input: grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 Output: 1

 Example 2:
 Input: grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 Output: 3

 Constraints:
 m == grid.length
 n == grid[i].length
 1 <= m, n <= 300
 grid[i][j] is '0' or '1'.

 Leetcode link: https://leetcode.com/problems/number-of-islands/description/
 **/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        int count = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid, int row, int col) {
        if (isOutOfBounds(row, col, grid)) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
    public static boolean isOutOfBounds(int row, int col, char[][] grid) {
        return row < 0 || col < 0 || row >= grid.length || col >= grid[0].length;
    }
}
