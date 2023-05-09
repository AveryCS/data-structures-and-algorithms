package com.practice.recursionproblems;
/**Problem statement:
 Given an array of ints, sum up the array using head recursion**/
public class SumUpArrayWithHeadRecursion {
    public static void main(String[] args) {
        int [] nums = new int []{2,7,10,3};

        System.out.print("The sum of the array is "+ sumArray(nums,0) +".");
    }

    /**The implementation of this method includes head/non-tail recursion, meaning that the recursive call does not come
     * at the end of the method and that there are operations being performed after the recursive call.
     *
     * In this case, the recursive calls go to the end of the call stack and the sum is calculated on the way back.
     *
     * */
    public static int sumArray(int [] nums, int index){

        if( index == nums.length){
            return 0;
        }
        int temp = nums[index];

        int total = sumArray(nums, index +1);
        return total +temp;

    }
}
