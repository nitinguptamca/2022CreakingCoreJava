package com.hardQuestion.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The problem is that we want to sort a T[] one-dimensional array of integers in O(N) running time -
 * and without any extra memory.
 * The array can contain values: 0, 1 and 2 (check out the theoretical section for further information).
 * for example array like [1,2,2,1,2,1,0,1,0] after sorting [0,0,1,1,1,1,2,2,2]
 * inventor Edsger Dijkstra
 */
public class DutchFlagProblem {
    static int[] edsgerDijkstra = new int[]{2, 1, 2, 2, 1, 2, 1, 0, 1, 0};

    public static void main(String[] args) {
        dutchSort(edsgerDijkstra);
        System.out.println(Arrays.toString(edsgerDijkstra));
        List<Integer>  sss=Arrays.stream(edsgerDijkstra).sorted().boxed().collect(Collectors.toList());
        System.out.println(sss);
    }


    private static void dutchSort(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        // we know that 1 is the middle item (0, 1, 2)
        int pivot = 1;

        // it has O(N) linear running time
        while (j <= k) {
            // when item with index j = 0
            if (nums[j] < pivot) {
                swap(i, j);
                i++;
                j++;
                // item is 2
            } else if (nums[j] > pivot) {
                swap(j, k);
                k--;
                // the item is 1
            } else {
                j++;
            }
        }
    }

    private static void swap(int i, int j) {
        int temp = edsgerDijkstra[i];
        edsgerDijkstra[i] = edsgerDijkstra[j];
        edsgerDijkstra[j] = temp;
    }
}