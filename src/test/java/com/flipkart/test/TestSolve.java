package com.flipkart.test;

import java.util.Arrays;

public class TestSolve {
    public static void main(String args[]){
      int [] arr = new int[2];
      int []arr2;
      arr2 = new int[3];
      int [] arr3 = {1,3,2,4};
        System.out.println(arr3[0] + " " +arr[0]);
        System.out.println(arr3.length);
        arr3[1]=10;
        System.out.println(arr3[1]);
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
      //  Arrays.sort(arr3);
        int[]copy = Arrays.copyOf(arr3,arr3.length+1);
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.equals(arr3,copy));
        int[] arr4 = {40, 10, 30, 20};

        System.out.println(Arrays.binarySearch(arr4,40)+" binary search");



    }
}
