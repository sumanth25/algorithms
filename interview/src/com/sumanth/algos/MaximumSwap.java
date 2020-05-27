package com.sumanth.algos;
/*
 Given a non-negative integer N, you could do at-most K swap operation on digits to get the maximum valued number.
 Return the maximum valued number you could get.

Example 1:

Input (N): 2736
Swaps (k): 1
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:

Input (N): 2736
Swaps (k): 2
Output: 7632
Explanation: Swap the number 2 and the number 7.
             Swap the number 2 and the number 6

Example 2:

Input (N): 9973
Swaps (k): 2
Output: 9973
Explanation: No swap.

Note:

    The given number is in the range [0, 10^8]

 */
public class MaximumSwap {
    public static void maxNumberSwap(){
        int input = 2736;
        int k = 2;
        int output = maximumNumberWithKSwaps(input,k);
        System.out.println("Input:"+input);
        System.out.println("Output:"+output);
    }

    /*
     *  Algorithm providing maximum number with allowed K number of swaps
     */
    private static int maximumNumberWithKSwaps(int num, int k) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        //create position index of the given number based on latest position of digits
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            //compare fom largest and swap with current smallest
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    k--;
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    break;
                }
            }
            if(k==0) {
                return Integer.valueOf(new String(A));
            }
        }
        System.out.println("No Swap!");
        return num;
    }

}
