package com.sumanth.algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Write a function to check whether two given strings are anagram of each other or not.
An anagram of a string is another string that contains same characters, only the order of
characters can be different. For example, “abcd” and “dabc” are anagram of each other.
Ex: triangle integral
Keep Peek
 */
public class AnagramOptimized {
    public static void check(){
        String str1="triangle";
        String str2="integral";
        boolean isAnagram=anagram(str1,str2);
        System.out.println("Strings "+str1+" and "+str2+" are anagrams: "+isAnagram);
    }

    // Algorithm which checks if anagram
    public static boolean anagram(String s, String t) {
        // Strings of unequal lengths can't be anagrams
        if(s.length() != t.length()) {
            return false;
        }

        // They're anagrams if both produce the same 'frequency map'
        return frequencyMap(s).equals(frequencyMap(t));
    }

    // For example, returns `{b=3, c=1, a=2}` for the string "aabcbb"
    private static Map<Character, Integer> frequencyMap(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : str.toLowerCase().toCharArray()) {
            Integer frequency = map.get(c);
            map.put(c, frequency == null ? 1 : frequency+1);
        }
        return map;
    }


}

/*
  Time Complexity O(n)
*/