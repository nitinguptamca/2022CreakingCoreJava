package com.datastructure.sorting;

import java.util.Arrays;

/**
 * reverse the input String ="ab!cd*e";
 * expected    output String="ed!cb*a"
 */
public class ReverseTheStringButNotSpecialCharacter {
    static String input = "ab!cd*e";
    static char[] charsArr = input.toCharArray();

    public static void main(String[] args) {
        System.out.println("\n ************start **********");
        System.out.println(Arrays.toString(charsArr));
        int i = 0, j = 0, k = charsArr.length - 1;
        while (i <= k) {
            if (isSpecialCharacter(charsArr[i])) {
                charsArr[i] = charsArr[i];
                i++;
            } else if (isSpecialCharacter(charsArr[k])) {
                charsArr[k] = charsArr[k];
                k--;
            } else {
                swap(i, k);
                i++;
                k--;
            }
        }
        System.out.println("\n " + Arrays.toString(charsArr));
    }

    private static void swap(int i, int k) {
        char tmp = charsArr[k];
        charsArr[k]=charsArr[i];
        charsArr[i] =tmp;
    }

    public static boolean isSpecialCharacter(char ch) {
        if (!Character.isAlphabetic(ch)) return true;
        else return false;
    }
}
