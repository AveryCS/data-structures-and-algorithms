package com.practice.recursionproblems;
import java.util.ArrayList;
import java.util.List;

/**Problem statement:
 Given an array of ints, sum up the array recursively **/

public class SumUpArrayRecursively {

    static public void main( String args[] ) {
        int [] nums = new int []{2,7,10,3};

        System.out.print("The sum of the array is "+ sumArray(nums,0) +".");

    }

    public static int sumArray( int[] nums, int index){
        if(index >= nums.length){
            return 0;
        }

        return nums[index]+ sumArray(nums, index +1);
    }
}
