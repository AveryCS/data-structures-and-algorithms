package com.practice.recursionproblems;
import java.io.*;
import java.util.*;
/**Problem statement:
 Given a 2D array of ints, sum up the array recursively **/

public class SumUpTwoDArrayRecursively {
    static public void main( String args[] ) {
        int[][] nums = new int[][]{
                {2, 7, 9},
                {3, 0, 1},
                {2, 3, 9}
        };
        Set<List<Integer>> set = new HashSet<>();
        System.out.print("The sum of the 2D array is " + sumArray(nums, 0, 0, set));
    }

    public static int sumArray( int [][] nums, int row, int col, Set<List<Integer>> set){
        int width= nums[0].length;
        int height = nums.length;

        if(row>= height || col >= width){
            return 0;
        }
        if(set.contains(List.of(row,col))){
            return 0;
        }
        set.add(List.of(row, col));
        return nums [row][col]+ sumArray(nums,row, col+1,set) + sumArray(nums,row+1, col,set);

    }
}

