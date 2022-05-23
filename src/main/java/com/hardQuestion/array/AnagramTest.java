package com.hardQuestion.array;

import java.util.Arrays;

public class AnagramTest {
    public static void main(String[] args) {

        System.out.println(isAnagramCounting("asdfg" ,"fsdag"));
      //  System.out.println(isAnagram("asdfg" ,"fsdag"));
    }

    private static boolean isAnagram(String string1, String string2) {
        char[] a1 = string1.toCharArray();
        char[] a2 = string2.toCharArray();
       /* Arrays.sort(a1);
        Arrays.sort(a2);*/
        insertionSort(a1);
        insertionSort(a2);
        return Arrays.equals(a1, a2);
    }

    static public void insertionSort(char[] chArr){
        for (int i =0; i < chArr.length-1 ; i++) {
            for (int j = i+1; j>0 ; j--) {
                if(chArr[j-1] > chArr[j])  swap(j-1 ,j ,chArr)  ;
            }
        }
    }

    private static void swap(int j, int i ,char[] str) {
        char tmp = str[j];
        str[j] =str[i];
        str[i]=tmp;
    }

    static public boolean isAnagramCounting(String string1, String string2) {
        int CHARACTER_RANGE= 256;
        if (string1.length() != string2.length()) {
            return false;
        }
        int count[] = new int[CHARACTER_RANGE];
        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            count[string2.charAt(i)]--;
        }
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}


