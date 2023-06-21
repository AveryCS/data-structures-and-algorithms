package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 Given an m x n grid of characters board and a string word, return true if word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example 1:
 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 Output: true

 Example 2:
 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 Output: true

 Example 3:
 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 Output: false

 Constraints:
 m == board.length
 n = board[i].length
 1 <= m, n <= 6
 1 <= word.length <= 15
 board and word consists of only lowercase and uppercase English letters.
 Leetcode link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 **/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.length() <= 0) {
            return false;
        }
        int[][] tracker = new int[board.length][board[0].length];
        char firstLetter = word.charAt(0);
        for (int row = board.length - 1; row > -1; row--) {
            for (int col = board[0].length - 1; col > -1; col--) {
                if (board[row][col] == firstLetter) {
                    if (search(board, word, row, col, 0, tracker)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean search(char[][] board, String word, int row, int col, int index, int[][] tracker) {
        if (index == word.length()) {
            return true;
        }
        if (isOutOfBounds(row, col, board)) {
            return false;
        }
        if (tracker[row][col] == 1) {
            return false;
        }
        char letterToFind = word.charAt(index);
        if (board[row][col] != letterToFind) {
            return false;
        }
        tracker[row][col] = 1;
        //means the letter was found
        index++;
        boolean left = search(board, word, row, col - 1, index, tracker);
        boolean right = search(board, word, row, col + 1, index, tracker);
        boolean up = search(board, word, row - 1, col, index, tracker);
        boolean down = search(board, word, row + 1, col, index, tracker);

        tracker[row][col] = 0;

        return left || right || up || down;
    }
    public static boolean isOutOfBounds(int row, int col, char[][] board) {
        return col >= board[0].length || row >= board.length || col < 0 || row < 0;
    }
}
