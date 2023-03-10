package com.practice.miscellaneous;
import java.util.*;
public class IterativeBinarySearch {
    public static void main(String[] args) {
        int [] nums = {1,3,5,7};
        System.out.println(bSearch(nums,0,nums.length, 3));

    }
    public static int bSearch( int[] nums, int begin, int end, int target){
        int middle = (begin +end)/2;
        while( begin!=middle && end!=middle && begin<nums.length){
            middle = (begin + end)/2;
            if(nums [middle] == target){
                return middle;
            }else if(nums[middle]> target){
                end = middle-1;
            }else if(nums[middle]<target){
                begin = middle +1;
            }
        }
        return -1;
    }
}
