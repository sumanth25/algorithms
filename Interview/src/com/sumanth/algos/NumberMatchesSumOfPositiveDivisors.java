package com.sumanth.algos;
/*
    Find if N is equal to sum of positive divisors except itself (exclude N as divisor) and
    print "YES" on match and "NO" on not matching
    Example:
    N=28 -> YES
    N=120 -> NO
    N=1 -> NO
 */
public class NumberMatchesSumOfPositiveDivisors {
    public static void findSumAndCompare() {
        int N=28;
        String match=calculateMatch(N);
        System.out.println("N matches sum of its positive divisors: "+match);
    }

    private static String calculateMatch(int N) {
        //Edge case
        if(N==1){
            return "NO";
        }

        int sum=0;
        // find positive divisors till N-1
        for (int i = 1; i < N-1; i++) {
            // sum only if it's a divisor
            if(N%i==0){
                sum+=i;
            }
        }
        //check match
        if(N==sum){
            return "YES";
        }
        return "NO";
    }
}
