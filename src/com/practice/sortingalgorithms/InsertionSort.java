package com.practice.sortingalgorithms;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 8, 0, 9, 6, 1, 13, 100, 101, 7};

        for (int j = 1; j < nums.length; j++) {
            for (int k = j; k > 0; k--) {
                if (nums[k] < nums[k - 1]) {
                    swap(nums, k);
                }
            }
        }
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void swap(int[] nums, int pointer) {
        int temp = nums[pointer];
        nums[pointer] = nums[pointer - 1];
        nums[pointer - 1] = temp;
    }
}
