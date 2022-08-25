package com.practice.sortingalgorithms;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 8, 0, 9, 6, 1, 13, 100, 101, 7};
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[temp]) {
                    temp = j;
                }
            }
            if (temp != i) {
                swapTempToFront(nums, temp, i);
            }
        }
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void swapTempToFront(int[] nums, int temp, int i) {
        int swap = nums[temp];
        nums[temp] = nums[i];
        nums[i] = swap;
    }
}
