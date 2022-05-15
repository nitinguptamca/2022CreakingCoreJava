package com.datastructure.sorting;

public class App {

    public static void main(String[] args) {

       int[] nums1 = {9, 1, 5, 2, 4, 3, 8, 7,0};

        int[] nums = {99999, 111111, 55555, 22222, 44444, 33333, 88888, 7555556,};

        CountingSort sort = new CountingSort(nums1);
        sort.sort();
        sort.showArray();
    }
}
