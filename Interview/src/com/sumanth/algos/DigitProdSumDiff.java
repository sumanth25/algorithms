package com.sumanth.algos;
/*
Given a positive integer number n, your task is to calculate the difference between the product of its digits and the sum of its digits.

Note: The order matters; the answer should be of the form product - sum (and not sum - product).

Example

    For n = 123456, the output should be digitsManipulations(n) = 699.
        The product of the digits is equal to 1 * 2 * 3 * 4 * 5 * 6 = 720.
        The sum of the digits is equal to 1 + 2 + 3 + 4 + 5 + 6 = 21.

    So the final answer is 720 - 21 = 699.

    For n = 1010, the output should be digitsManipulations(n) = -2.
        The multiplication of the digits is equal to 1 * 0 * 1 * 0 = 0.
        The sum of the digits is equal to 1 + 0 + 1 + 0 = 2.

    So the final answer is 0 - 2 = -2.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer n
 */
public class DigitProdSumDiff {
    public static void calculate() {
        int n = 123456;
        int res=digitsManipulations(n);
        System.out.println("Difference between the product and sum of its digits "+n+" is: "+res);
    }

    //Algorithm to provide diff between prod and sum of digits
    private static int digitsManipulations(int n) {
        String number = String.valueOf(n);
        int product=1;
        int sum=0;
        for (int i = 0; i < number.length(); i++) {
            char ch=number.charAt(i);
            //extract each digit as Integer
            int digit=Integer.parseInt(Character.toString(ch));
            product*=digit;
            sum+=digit;
        }
        // Diff
        return product-sum;
    }
}
