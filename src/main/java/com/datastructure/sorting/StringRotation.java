package com.datastructure.sorting;

// Java program to check if two given strings are rotations of
// each other

/**
 * Input : ABACD, CDABA
 * Output : True
 *
 * Input : GEEKS, EKSGE
 * Output : True
 * Algorithm: areRotations(str1, str2)
 *
 *     1. Create a temp string and store concatenation of str1 to
 *        str1 in temp.
 *                           temp = str1.str1
 *     2. If str2 is a substring of temp then str1 and str2 are
 *        rotations of each other.
 *
 *     Example:
 *                      str1 = "ABACD"
 *                      str2 = "CDABA"
 *
 *      temp = str1.str1 = "ABACDABACD"
 *      Since str2 is a substring of temp, str1 and str2 are
 *      rotations of each other.
 *      Input: string1 = “amazon”, string2 = “azonam”
 * Output: Yes
 * // rotated anti-clockwise
 * Input: string1 = “amazon”, string2 = “onamaz”
 * Output: Yes
 * // rotated clockwise
 */

class StringRotation
{
    /* Function checks if passed strings (str1 and str2)
       are rotations of each other */
    static boolean areRotations(String str1, String str2)
    {
        // There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1.
        return (str1.length() == str2.length()) &&
                ((str1 + str1).indexOf(str2) != -1);
    }

    // Driver method
    public static void main (String[] args)
    {
        String str1 = "AACD";
        String str2 = "ACDA";

        if (areRotations(str1, str2))
            System.out.println("Strings are rotations of each other");
        else
            System.out.printf("Strings are not rotations of each other");
    }
}
// This code is contributed by  munjal