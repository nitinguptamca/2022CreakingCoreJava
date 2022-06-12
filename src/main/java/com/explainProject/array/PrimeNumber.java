package com.explainProject.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Java Program To Print Odd Numbers From 1 To 100
 * In this program, we will learn to code the Java Program To Print Prime Numbers From 1 To 100.
 * Let’s understand How to print all the prime numbers from 1 to 100 in Java Programming Language. In
 */

public class PrimeNumber {
    public static void main(String[] args) {
        List<Integer> listOfOddNumbers =getPrimeNumberFrom1To100();
       listOfOddNumbers.forEach(System.out::println);
    }

    private static List<Integer> getPrimeNumberFrom1To100() {
        List<Integer>   oddNumbers = new ArrayList<>();
        oddNumbers.add(2);
        for (int i = 2; i < 100; i++) {
            if(isOddNumber(i)){
                oddNumbers.add(i);
            };
        }
        return oddNumbers;
    }

    private static boolean isOddNumber(int number) {
        int sqrtval =(int)Math.sqrt(number);
        for (int i = 2; i <=sqrtval; i++) {
           if(number%i==0){
               return false;
           }
        }
        return true;
    }
}
