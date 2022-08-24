package com.practice.sortingalgorithms;
import java.util.*;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,8,2,0,7,3,18,9,11};
             mergeSort(nums);
               for(int i: nums){
            System.out.println(i);
               }
         }

         public static int[] mergeSort(int[] k) {
           if (k.length < 2) {
             return k;
           }
           int[] leftArr = new int[k.length / 2];
           leftArr = Arrays.copyOfRange(k, 0, k.length / 2);

           int[] rightArr = new int[k.length - (k.length / 2)];
           rightArr = Arrays.copyOfRange(k, (k.length / 2), k.length);

           mergeSort(leftArr);
           mergeSort(rightArr);
           merge(k, leftArr, rightArr);
           return k;
         }

         private static void merge(int[] original, int[] left, int[] right) {

           int i = 0;
           int j = 0;
           int k = 0;
           while (i < left.length && j < right.length) {
             if (left[i] < right[j]) {
               original[k] = left[i];
               i++;
             } else {
               original[k] = right[j];
               j++;
             }
             k++;
           }

           while (i < left.length) {
             original[k] = left[i];
             i++;
             k++;
           }

           while (j < right.length) {
             original[k] = right[j];
             j++;
             k++;
           }
    }
}
