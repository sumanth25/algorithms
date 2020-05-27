package com.sumanth.algos;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubstring {
    public static void longestSubstringAlgo(){
        String s="abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    /*
     *   Algorithm: Sliding Window
     */
    private static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
/*
Complexity Analysis:

    Time complexity : O(n). We traverse the list containing nnn elements only once.
    Each look up in the table costs only O(1) time.

    Space complexity : O(n). The extra space required depends on the number of items
    stored in the hash table, which stores at most nnn elements.

 */
