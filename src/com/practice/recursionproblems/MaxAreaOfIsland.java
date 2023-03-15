package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

 The area of an island is the number of cells with a value 1 in the island.

 Return the maximum area of an island in grid. If there is no island, return 0.

 Example 1:
 Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 Output: 6
 Explanation: The answer is not 11, because the island must be connected 4-directionally.

Leetcode link: https://leetcode.com/problems/max-area-of-island/
 **/
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        Set < List < Integer >> set = new HashSet < > ();
        int width = grid[0].length;
        int height = grid.length;
        int islandCount = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 1 && !set.contains(List.of(row, col))) {
                    set.add(List.of(row, col));
                    islandCount = Math.max(bfs(row, col, grid, set), islandCount);
                }
            }
        }
        return islandCount;
    }
    public static int bfs(int row, int col, int[][] grid, Set < List < Integer >> set) {
        int width = grid[0].length;
        int height = grid.length;
        int count = 1;

        Queue < List < Integer >> q = new ArrayDeque < > ();
        q.add(List.of(row, col));
        while (!q.isEmpty()) {
            List < Integer > coordinates = q.remove();
            int tempRow = coordinates.get(0);
            int tempCol = coordinates.get(1);


            if (!set.contains(List.of(tempRow + 1, tempCol)) && tempRow + 1 < height && grid[tempRow + 1][tempCol] == 1) {
                set.add(List.of(tempRow + 1, tempCol));
                q.add(List.of(tempRow + 1, tempCol));
                count++;
            }

            if (!set.contains(List.of(tempRow, tempCol + 1)) && tempCol + 1 < width && grid[tempRow][tempCol + 1] == 1) {
                set.add(List.of(tempRow, tempCol + 1));
                q.add(List.of(tempRow, tempCol + 1));
                count++;
            }

            if (!set.contains(List.of(tempRow, tempCol - 1)) && tempCol - 1 > -1 && grid[tempRow][tempCol - 1] == 1) {
                set.add(List.of(tempRow, tempCol - 1));
                q.add(List.of(tempRow, tempCol - 1));
                count++;
            }

            if (!set.contains(List.of(tempRow - 1, tempCol)) && tempRow - 1 > -1 && grid[tempRow - 1][tempCol] == 1) {
                set.add(List.of(tempRow - 1, tempCol));
                q.add(List.of(tempRow - 1, tempCol));
                count++;
            }
        }
        return count;

    }
}
