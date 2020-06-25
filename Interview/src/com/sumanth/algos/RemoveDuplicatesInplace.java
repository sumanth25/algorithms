package com.sumanth.algos;
/*
Given a sorted array, remove the duplicates in place such that each element appear
only once and return the new length. Do not allocate extra space for another array,
you must do this in place with constant memory.
For example, given input array A = [1,1,2], your function should return length = 2,
and A is now [1,2].
 */
public class RemoveDuplicatesInplace {
    public static void doIt(){
        int[] A={1, 2, 2, 3, 3};
       removeDuplicatesNaive(A);
    }


    // Algorithm to remove duplicates in place/ without extra space
    private static void removeDuplicatesNaive(int[] A) {

        if (A.length < 2){
            display(A,1);
            return;
        }

        int j = 0;
        int i = 1;
        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }
        int count = j + 1;
        display(A,count);
        return;
    }

    // display elements
    private static void display(int[] a, int position) {
        for (int i = 0; i < position; i++) {
            System.out.println(a[i]+",");
        }
    }
}
