package com.hardQuestion.array;

/**
 * Find out first not repeating sub string
 * String s ="abcabcbb"
 * Expected answer is "abc";
 */
public class LongestSubstringWithoutRepeatingCharacters {
    static String input = "abcabcbb";
    public static void main(String[] args) {
        System.out.println("\n longest  ::"+ getLongestStringFromBeginning(input));
    }

    private static String getLongestStringFromBeginning(String input) {
        String longestString="";
        mainLoop:
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j < input.length(); j++) {
                String currentStr= input.substring(i ,j);
                String reverseStr = new StringBuffer(currentStr).reverse().toString();
                if(currentStr.length()==1) {
                    longestString=currentStr;
                }else if(longestString.length() < currentStr.length()
                        //&& !currentStr.equalsIgnoreCase(reverseStr)
                        && currentStr.charAt(0)!= reverseStr.charAt(0)
                ){
                    longestString=currentStr;
                }else{
                  break mainLoop;
                }
            }
        }

        return longestString;
    }
}
