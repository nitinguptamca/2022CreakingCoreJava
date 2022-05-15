package com.datastructure.sorting;

public class BucketSort {

    private int[] nums;

    public BucketSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {
        int[] newbucket = new int[10];
        for (int i = 0; i < nums.length; i++) {
            newbucket[nums[i]]++;
        }
        int position = 0;
        for (int b = 0; b < newbucket.length; b++)
            for (int c = 0; c < newbucket[b]; c++)
                nums[position++] = b;
    }
    public void showSortedArray() {
        for(int i=0;i<nums.length;++i)
            System.out.print(nums[i]+" ");
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
