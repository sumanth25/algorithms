package com.sumanth.algos;
/*
    Find largest possible integer by removing 1 digit
    Examples:
    1. 2348762 -> Remove 2 to get 348762
    2. 986543 -> Remove 3 to get 98654
    3. 871654 -> Remove 1 to get 87654
 */
public class LargestInteger {
    static String res="";

    public static void findLargestIntegerWithOneRemoval() {
        String input="871654";
        int removeDigits=1;
        calculateLargestRemovingOneDigit(input,removeDigits);
        System.out.println("Largest possible integer by removing 1 digit in "+input+" is "+res);
    }

    // Algorithm to calculate largest number by removing only 1 digit
    private static void calculateLargestRemovingOneDigit(String input, int removeDigits) {

        // If 0 digits to be removed then return input as it is
        if(removeDigits==0){
            res += input;
            return;
        }

        int len = input.length();

        // IF more or equal to input character to be removed return
        if(len<=removeDigits)
            return;

        // Find the smallest character
        int minIndex=0;
        for (int i = 1; i <= removeDigits ; i++) {
            if(input.charAt(i)>input.charAt(minIndex)) {
                minIndex=i;
            }
        }

        // Append largest to res
        res+= input.charAt(minIndex);

        // substr from minIndex+1 to strlen -1
        String newStr=input.substring(minIndex+1);

        // Reccur
        calculateLargestRemovingOneDigit(newStr, removeDigits - minIndex);
    }
}
