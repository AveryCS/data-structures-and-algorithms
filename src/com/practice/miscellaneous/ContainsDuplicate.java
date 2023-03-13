package com.practice.miscellaneous;
import java.util.*;

/**
 * Problem statement: Create an array and determine if there are any duplicates.
 * */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("The array cannot be null.");
        }
        Set < Integer > set = new HashSet < > ();

        for (int i: nums) {
            if (!set.contains(i)) {
                System.out.println("short circuiting");
                return true;
            };
        }
        return false;
    }
}
