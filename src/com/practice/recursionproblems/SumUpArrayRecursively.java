package com.practice.recursionproblems;
import java.util.ArrayList;
import java.util.List;

/**Problem statement:
 Given an array of ints, sum up the array using tail recursion**/

public class SumUpArrayRecursively {

    static public void main( String args[] ) {
        int [] nums = new int []{2,7,10,3};

        System.out.print("The sum of the array is "+ sumArray(nums,0) +".");

    }
    /**The implementation of this method includes tail recursion, meaning that the recursive call is at the tail end/
     * no additional operations are being done after the recursive call.
     *
     * A helpful way to think about this is that in this call, I'm adding the element that I'm on (nums[index]) and
     * trusting the recursive call to sum up the remainder of the array.
     *
     * */
    public static int sumArray( int[] nums, int index){
        if(index == nums.length){
            return 0;
        }

        return nums[index]+ sumArray(nums, index +1);
    }
}
