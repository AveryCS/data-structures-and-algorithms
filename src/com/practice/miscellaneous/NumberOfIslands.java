
package com.practice.miscellaneous;
import java.util.*;
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

 Leetcode link: https://leetcode.com/problems/number-of-islands/
 **/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        Set<List<Integer>> set = new HashSet<>();
        int width = grid[0].length;
        int height = grid.length;
        int islandCount = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == '1' && !set.contains(List.of(row, col))) {
                    // add coordinates to the set
                    set.add(List.of(row, col));
                    // perform BFS
                    bfs(row, col, grid, set);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public static void bfs(int row, int col, char[][] grid, Set<List<Integer>> set) {
        int width = grid[0].length;
        int height = grid.length;

        Queue<List<Integer>> q = new ArrayDeque<>();
        q.add(List.of(row, col));
        while (!q.isEmpty()) {
            List<Integer> coordinates = q.remove();
            int tempRow = coordinates.get(0);
            int tempCol = coordinates.get(1);

            // check 1 below
            if (!set.contains(List.of(tempRow + 1, tempCol)) && tempRow + 1 < height && grid[tempRow + 1][tempCol] == '1') {
                set.add(List.of(tempRow + 1, tempCol));
                q.add(List.of(tempRow + 1, tempCol));
            }
            // check to the right
            if (!set.contains(List.of(tempRow, tempCol + 1)) && tempCol + 1 < width && grid[tempRow][tempCol + 1] == '1') {
                set.add(List.of(tempRow, tempCol + 1));
                q.add(List.of(tempRow, tempCol + 1));
            }
            // check left
            if (!set.contains(List.of(tempRow, tempCol - 1)) && tempCol - 1 > -1 && grid[tempRow][tempCol - 1] == '1') {
                set.add(List.of(tempRow, tempCol - 1));
                q.add(List.of(tempRow, tempCol - 1));
            }
            // check 1 above
            if (!set.contains(List.of(tempRow - 1, tempCol)) && tempRow - 1 > -1 && grid[tempRow - 1][tempCol] == '1') {
                set.add(List.of(tempRow - 1, tempCol));
                q.add(List.of(tempRow - 1, tempCol));
            }
        }
        return;

    }
}
