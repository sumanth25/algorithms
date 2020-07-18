package com.sumanth.algos;

import java.util.HashMap;

/*
Given an array a of non-negative integers, find the number of distinct pairs of integers for which the sum is equal to k.

Example

For k = 8 and a = [2, 3, 6, 2, 8], the output should be
countPairsWithSum(k, a) = 1.
For k = 11 and a = [10, 9, 4, 0, 8, 1, 7, 6, 10, 5], the output should be
countPairsWithSum(k, a) = 3.

There are four pairs that sum up to 8: (a[0], a[2]), (a[2], a[0]), (a[2], a[3]), and (a[3], a[2]), but all of them consist
of the same values 2 and 6, so there is only one unique pair.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer k

    Guaranteed constraints:
    0 ≤ k ≤ 109.

    [input] array.integer a

    Guaranteed constraints:
    2 ≤ a.length ≤ 105,
    0 ≤ a[i] ≤ 109.

    [output] integer
        The number of distinct pairs of integers in a that sum up to k.
 */
public class FreqOfPairsWithSum {

    public static void findCount() {
        int k = 8;
        int[] a = {2, 3, 6, 2, 8};
        int count = countPairsWithSum(k, a);
        System.out.println("The number of distinct pairs of integers in a that sum up to "+k+" is: "+count);
    }

    // algorithm to calculate unique pairs
    private static int countPairsWithSum(int k, int[] a) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int count=0;
        for (int i = 0; i < a.length; i++) {
            // Enter only if a[i] is not present in both keys and values
            if(!(map.keySet().contains(a[i])&&map.values().contains(a[i]))){
                int diff=k-a[i];
                // check if distinct and only then increment
                if(null!=map.get(a[i])&&(map.get(a[i])==diff)){
                    count++;
                }else {
                    // enter if not found in map
                    map.put(diff, a[i]);
                }
            }
        }
        // return distinct pairs making up k
        return count;
    }
}
