package com.sumanth.algos;

import java.util.*;

/*
    Array A=[2,3,2,5,3,2,7,11,3,2,5,7,5]
    Sort based on highest frequency of numbers
 */
public class HighestFreqSort {
    public static void findFreqAndSort() {
        int[] input= {2,3,2,5,3,3,3,2,7,11,3,2,5,7,5};
        // Find frequencies into map
        HashMap freqMap = findfrequenciesByCount(input);
        // sort map by values
        freqMap=sortByValues(freqMap);

        //display values
        freqMap.keySet().stream().forEach(ele->{
            System.out.println(ele);
        });

    }

    // Find frequencies into map
    private static HashMap<Integer, Integer>  findfrequenciesByCount(int[] input) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : input) {
            Integer frequency = map.get(i);
            map.put(i, frequency == null ? 1 : frequency+1);
        }
        return map;
    }

    // sort map by values
    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
