package com.practice.recursionproblems;

import java.util.*;

/**
 * Problem statement:
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * <p>
 * Return the modified image after performing the flood fill.
 * <p>
 * Example 1:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * Example 2:
 * <p>
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 * Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 * <p>
 * Constraints:
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], color < 216
 * 0 <= sr < m
 * 0 <= sc < n
 * <p>
 * Leetcode link: https://leetcode.com/problems/flood-fill/description/
 **/
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int width = image[0].length;
        int height = image.length;
        int[][] result = Arrays.copyOf(image, image.length);

        Set<List<Integer>> set = new HashSet<>();
        fill(image, sr, sc, color, image[sr][sc], set);
        return image;
    }

    public static void fill(int[][] image, int row, int col, int color, int startColor, Set<List<Integer>> set) {
        if (isOutOfBounds(row, col, image)) {
            return;
        }
        if (set.contains(List.of(row, col))) {
            return;
        }
        set.add(List.of(row, col));
        if (image[row][col] != startColor) {
            return;
        } else {
            image[row][col] = color;
        }
        //up
        fill(image, row - 1, col, color, startColor, set);

        //down
        fill(image, row + 1, col, color, startColor, set);

        //left
        fill(image, row, col - 1, color, startColor, set);
        //right
        fill(image, row, col + 1, color, startColor, set);
    }

    public static boolean isOutOfBounds(int row, int col, int[][] image) {
        int width = image[0].length;
        int height = image.length;

        return row < 0 || row >= height || col < 0 || col >= width;
    }
}
