package com.practice.recursionproblems;
import java.util.*;

/**Return the position of a target by implementing a binary search. If it does not exist, return a -1.
 * */


public class BinarySearchRecursively {
    public static void main(String[] args) {
        int [] nums ={ -1,2,9,50};
        int target = 9;
        System.out.println(bSearch(nums, 0, nums.length, target));
    }

    public static int bSearch(int[] nums, int begin, int end, int target) {
        int middle = (begin + end) / 2;
        if (middle < nums.length && nums[middle] == target) {
            return middle;
        } else if (middle == begin || middle == end) {
            return -1;
        } else if (nums[middle] < target) {
            begin = middle + 1;
            return bSearch(nums, begin, end, target);
        } else {
            end = middle ;
            return bSearch(nums, begin, end, target);
        }
    }
}
