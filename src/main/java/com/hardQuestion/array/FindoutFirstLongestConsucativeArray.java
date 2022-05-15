package com.hardQuestion.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntPredicate;

public class FindoutFirstLongestConsucativeArray {
    static int[] intarray = {0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1};
    static int count = 2;
    static int result = 0;


    public static void main(String[] args) {
        boolean flag =false;
        for (int i = 1; i < intarray.length; i++) {
            if (intarray[i-1] == 1 && intarray[i] == 1) {
                System.out.println("count  " + count);
                result = Math.max(result, count);
                count++;
                flag=true;
            } else {
                if(flag) {
                    count = 2;
                }else {
                    count=0;
                }

            }
        }

        System.out.println(" result " + result);
    }
}
