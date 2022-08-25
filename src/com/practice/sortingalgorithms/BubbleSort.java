package com.practice.sortingalgorithms;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 8, 12, -1, 100, 99, 11, 3};

        int k = nums.length;
        for (int i = 0; i < k - 1; k--) {
            for (int j = i + 1; j < k; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j - 1, j);
                }
            }
        }
        for (int l : nums) {
            System.out.println(l);
        }
    }

    public static void swap(int[] array, int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}



