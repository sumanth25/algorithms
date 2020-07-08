package com.sumanth.algos;

import java.util.Arrays;
/*
Given a string str, find the length of the longest substring without repeating characters.

    For “ABCDAXYZPQ”, the longest substring is “BCDAXYZPQ”
    For “AAAA” the longest substring is “A”
    For “ABDEFGABEF”, there are 3 equal length longest substrings “ABDEFG", “BDEFGA” and “DEFGAB”,
                      so print the last one "DEFGAB"
 */
public class LargestNonRepeatingSubstr {
    private static final int NO_OF_CHARS = 256;

    public static void findlargestSubString() {
        String input="ABDEFGABEF";

        String result=computeLongestNonRepeatingSubString(input);
        System.out.println(result);
    }

    // Algorithm for finding longest Non-Repeating SubString
    private static String computeLongestNonRepeatingSubString(String input) {
        StringBuilder tempSubstr=new StringBuilder();
        String largestStr="";
        // last index of all characters is initialized
        // as -1
        int [] visited = new int[NO_OF_CHARS];
        Arrays.fill(visited, -1);

        // Move end of current window
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
                // check for visited array not having new char
                if(visited[ch]==-1) {
                    visited[ch]=i;
                    tempSubstr.append(input.charAt(i));
                }else{
                    // replace if it's largest or equals
                    if(tempSubstr.toString().length()>=largestStr.length()){
                        largestStr=tempSubstr.toString();
                    }
                    i=visited[ch];
                    // clear tempstr and reinitialise visited array
                    tempSubstr=new StringBuilder();
                    Arrays.fill(visited, -1);
                }
        }

        // Last loop if largest substr is present
        if(tempSubstr.toString().length()>largestStr.length()){
            largestStr=tempSubstr.toString();
        }

        return largestStr;
    }
}
