package com.sumanth.algos;
/*
Mona has a fascination with numbers. She likes numbers that have their digits in increasing order
like 149, 468, 789, etc. She does not like numbers that don't follow this rule
like 543, 664, 299, etc.

Given a number N as input, write a program in Java to find the largest number less than or
equal to N which will appeal to Mona's liking.

Input Format
An integer N which is less than 1,000,000.

Output Format
An integer which is less than or equal to N and which appeals to Mona's peculiar rules.

Sample Input
998
Sample Output
789
 */
public class LargestIncrementalNumber {

    public static void findLargestIncrementalNumber(){
        int N=998;
        int output=findLargestIncNo(N);
        System.out.println("Largest Incremental Number for "+N+" is "+output);
    }

    // Check and decrement by 1 until you find the number
    private static int findLargestIncNo(int n) {
        boolean incNumber=false;
        while(!incNumber){
            incNumber=checkIncrementalOrder(n);
            n=n-1;
        }
        return n+1;
    }

    // Algorithm to check if a given number is incremental order
    private static boolean checkIncrementalOrder(int n) {
        String numStr=String.valueOf(n);

        for (int i = 0; i < numStr.length()-1; i++) {
            if(numStr.charAt(i)<numStr.charAt(i+1)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
