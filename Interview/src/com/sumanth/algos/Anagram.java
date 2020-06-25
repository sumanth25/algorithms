package com.sumanth.algos;

import java.util.Arrays;
/*
Write a function to check whether two given strings are anagram of each other or not.
An anagram of a string is another string that contains same characters, only the order of
characters can be different. For example, “abcd” and “dabc” are anagram of each other.
Ex: Listen Silent
Keep Peek
 */
public class Anagram {
    public static void check(){
        String str1="Listen";
        String str2="Silent";
        boolean isAnagram=isAnagramSort(str1,str2);
        System.out.println("Strings "+str1+" and "+str2+" are anagrams: "+isAnagram);
    }

    // Algorithm which checks if anagram
   private static boolean isAnagramSort(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        char[] a1 = string1.toLowerCase().toCharArray();
        char[] a2 = string2.toLowerCase().toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}
