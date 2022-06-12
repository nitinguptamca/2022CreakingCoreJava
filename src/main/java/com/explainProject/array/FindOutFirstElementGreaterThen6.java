package com.explainProject.array;

import java.util.Arrays;

/**
 * find out first element which is greater then 6
 * concentrate on out put.
 */

public class FindOutFirstElementGreaterThen6 {


    public static void main(String[] args) {
        int[] aa= {1,2,3,4,5,6,7,8,9};
       int value= Arrays.stream(aa).filter( e ->{
            System.out.println(e);
            return e > 5;
        }).findFirst().getAsInt();

        System.out.println("result "+value);

    }
}
//output
/**
 * 1
 * 2,
 * 3
 * 4
 * 5
 * 6
 * result 6
 */
