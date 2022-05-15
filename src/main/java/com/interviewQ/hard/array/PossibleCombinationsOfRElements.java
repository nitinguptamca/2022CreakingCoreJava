package com.interviewQ.hard.array;


/**
 * Given an array of size n, generate and print all possible combinations of r
 * elements in array. For example, if input array is {1, 2, 3, 4} and r is 2,
 * then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
 * <br> if   r==3 then  <br>1 2 3 <br>
 *
 * 1 2 4<br>
 *
 * 1 2 5<br>
 *
 * 1 3 4<br>
 *
 * 1 3 5<br>
 *
 * 1 4 5<br>
 *
 * 2 3 4<br>
 *
 * 2 3 5<br>
 *
 * 2 4 5<br>
 *
 * 3 4 5<br>
 *
 */
public class PossibleCombinationsOfRElements {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int r = 3;
        int n = arr.length;
        printCombination(arr, n, r);
    }
    static void printCombination(int arr[], int n, int r) {
        // A temporary array to store all combination one by one
        int data[] = new int[r];
        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }

    static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {

        if (index == r) {
            for (int j = 0; j < r; j++)
                System.out.print(data[j] + " ");
            System.out.println("");
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }
}
