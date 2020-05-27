package com.sumanth.algos;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same
element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {
    public static void twoSumAlgo(){
        int[] nums=new int[]{2, 7, 11, 15};
        int target=9;
        int[] result = twoSum(nums, target);
        for (int item: result) {
            System.out.println(item);
        }
    }

    /*
     *   Algorithm
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[] { map.get(difference), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
/*
Complexity Analysis:

    Time complexity : O(n). We traverse the list containing nnn elements only once.
    Each look up in the table costs only O(1) time.

    Space complexity : O(n). The extra space required depends on the number of items
    stored in the hash table, which stores at most nnn elements.

 */
