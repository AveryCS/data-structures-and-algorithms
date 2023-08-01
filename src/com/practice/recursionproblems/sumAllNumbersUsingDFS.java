package com.practice.recursionproblems;
import java.util.*;

/**
 * Problem statement:
 * Create a 2D array of characcters with periods and numbers. Recursively sum up all of the numbers in the array.
 * <p>
 * This is a problem I created for myself, in order to practice depth first search.
 **/
public class sumAllNumbersUsingDFS {
    public static void main(String[] args) {
        char [][] board ={
                {'.','.','2','.'},
                {'.','9','.','.'},
                {'.','.','2','.'}
        };
        Set<List<Integer>> set = new HashSet<>();
        System.out.println(sumDigits(board, 0,0,set));

    }
    public static int sumDigits( char [][] board, int row, int col, Set<List<Integer>> set){
        if(isOutofBounds(row,col, board)){
            return 0;
        }
        if(set.contains(List.of(row,col))){
            return 0;
        }
        set.add(List.of(row, col));

        char current = board[row][col];

        int right = sumDigits(board,row,col+1, set);
        int down = sumDigits(board, row+1, col, set);

        if(Character.isDigit(current)){
            return Character.getNumericValue(current) +right +down ;
        }else{
            return right +down;
        }
    }
    public static boolean isOutofBounds(int row, int col, char[][] board){
        int width = board[0].length;
        int height = board.length;
        return row <0 || row >= height || col<0 || col >= width;

    }
}
