package com.explainProject.array;

/**
 * Remove consecutive vowels from string
 * Given a string s of lowercase letters, we need to remove consecutive vowels from the string
 * Input: geeks for geeks
 * Output: geks for geks
 * <p>
 * Input : your article is in queue
 * Output : your article is in qu
 */


public class RemoveConsecutiveVowelsFromString {
    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    //  static String input = "geeks for geeks";
    static String input = "your article is in queue";
    static String expectedOutput = "yor article is in qu";

    static String input1 = "youur artaeicle isau in queue";
    static String expectedOutput1 = "yor artacle isa in qu";

   public static void main(String[] args) {
        solution1(input1);
    }

    public static void solution1(String input) {
        String output="";
        boolean flag =false;
        for (int i = 1; i < input.length(); i++) {
            if(is_vow(input.charAt(i-1))  && is_vow(input.charAt(i)) ){
                if(!flag)
                    output+= String.valueOf(input.charAt(i-1));
                flag=true;
            }else{
                if(!flag)
                output+=String.valueOf(input.charAt(i-1));
                flag=false;
            }
        }
        System.out.println(output);
    }

    public static boolean isVowel(char c)
    {
        String vowels = "aeiouAEIOU";
        for(int i=0; i<10; i++)
            if(c==vowels.charAt(i))
                return true;
        return false;
    }

    static boolean is_vow(char c) {
        // this compares vowel // with character 'c'
        return (c == 'a') || (c == 'e') ||
                (c == 'i') || (c == 'o') ||
                (c == 'u');
    }


}
