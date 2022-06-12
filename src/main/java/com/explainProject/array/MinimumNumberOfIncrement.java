package com.explainProject.array;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/minimum-number-increment-operations-make-array-elements-equal/
 * We are given an array consisting of n elements. At each operation you can select any one element and increase rest of n-1 elements by 1. You have to make all elements equal performing such operation as many times you wish. Find the minimum number of operations needed for this.
 * Examples:
 *
 *
 * Input : arr[] = {1, 2, 3} <BR>
 * Output : Minimum Operation = 3  <BR>
 * Explanation : <BR>
 * operation | increased elements | after increment  <BR>
 *     1     |    1, 2            | 2, 3, 3 <BR>
 *     2     |    1, 2            | 3, 4, 3 <BR>
 *     3     |    1, 3            | 4, 4, 4 <BR>
 *
 * Input : arr[] = {4, 3, 4}  <BR>
 * Output : Minimum Operation = 2  <BR>
 * Explanation :  <BR>
 * operation | increased elements | after increment <BR>
 *      1    |    1, 2           | 5, 4, 4  <BR>
 *      2    |    2, 3           | 5, 5, 5 <BR>
 */
public class MinimumNumberOfIncrement {

    static void printMinOp(int arr[])
    {
        int arraySum, smallest, arr_size = arr.length;
        arraySum = 0;
        smallest = arr[0];
      ////  String s = new DecimalFormat("0.####").format(Double.parseDouble(value));
        // smallest =Arrays.stream(arr).min().getAsInt();
       // arraySum =Arrays.stream(arr).sum();
        for (int i = 0; i < arr_size; i++) {
            // If current element is smaller than update smallest
            if (arr[i] < smallest)
                smallest = arr[i];

            // find array sum
            arraySum += arr[i];
        }

        int minOperation = arraySum - arr_size * smallest;

        // Print min operation required
        System.out.println("Minimum Operation = " + minOperation);
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        int arr[] = { 5, 6, 2, 4, 3 };
        printMinOp(arr);
    }
}
