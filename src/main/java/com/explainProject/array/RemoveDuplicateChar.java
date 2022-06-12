package com.explainProject.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RemoveDuplicateChar {
    public static void main1(String[] args) {
        String str = "HFGDFGFJKJJJFTYERYVBCXFGDSUYUUNITINKHJFYTDXRSX";
        System.out.println("    " + removeDuplicate(str));
        String ssss = str.chars().mapToObj(c -> Character.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new , Collectors.counting()))
                .entrySet().stream()
                .map(entry -> String.valueOf(entry.getKey())).reduce("", (a, b) -> a + b);
        System.out.println("    " +ssss);
    }

    public static void main(String[] args) {
        String str = "HFGDFGFJKJJJFTYERYVBCXFGDSUYUUNITINKHJFYTDXRSX";
        removeDuplicateChar(str);
    }

    private static void removeDuplicateChar(String str){
        char[] charArray= str.toCharArray();
        int min =str.chars().min().getAsInt();
        int max= str.chars().max().getAsInt();
        char[] requiredChar= new char[max-min+1];
        boolean[]  maxChar= new boolean[256];
        String  sssss ="";
        for (int i = 0; i <charArray.length; i++) {
           if(!maxChar[charArray[i]]){
                sssss+= String.valueOf(charArray[i]);
               maxChar[charArray[i]]=true;
           }
        }
        System.out.println(sssss);
    }

    private static String removeDuplicate(String str) {
        int tail = 0;
        char[] charArray = str.toCharArray();
        char[]  tmp = new char[charArray.length];
        boolean[] hit = new boolean[256];
        for (int i = 0; i < charArray.length; ++i) {
            char dsd = charArray[i];
            if (!hit[charArray[i]]) {
                tmp[tail] = charArray[i];
                ++tail;
                hit[charArray[i]] = true;
            }
        }
        String ssss="";
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i]=='\u0000') continue;
            ssss+=tmp[i];
        }
        return ssss;
    }
}
