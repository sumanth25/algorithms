package com.sumanth.algos;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println("Welcome to Practice!");
        String[] strs = {"Flower","Flow","Flaw"};
        String res = longestCommonPrefix(strs);
        System.out.println("Result:" + res);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}

/*
Complexity Analysis

Time complexity : O(S) , where S is the sum of all characters in all strings.

Space complexity : O(1). We only used constant extra space.
 */
