package com.sumanth.algos;

import java.util.HashMap;
import java.util.Map;

/*
Finish the function numberToOrdinal, which should take a number and return it as a string with the correct
ordinal indicator suffix (in English). For example, 1 turns into "1st".

For the purposes of this challenge, you may assume that the function will always be passed a non-negative integer.
If the function is given 0 as an argument, it should return '0' (as a string).
To help you get started, here is an excerpt from Wikipedia's page on Ordinal Indicators:
    st is used with numbers ending in 1 (e.g. 1st, pronounced first)
    nd is used with numbers ending in 2 (e.g. 92nd, pronounced ninety-second)
    rd is used with numbers ending in 3 (e.g. 33rd, pronounced thirty-third)
    As an exception to the above rules, all the "teen" numbers ending with 11, 12 or 13 use -th (e.g. 11th,
    pronounced eleventh, 112th, pronounced one hundred [and] twelfth)
    th is used for all other numbers (e.g. 9th, pronounced ninth).

Specification
Challenge.numberToOrdinal(number)
take a number and return it as a string with the correct ordinal indicator suffix (in English)
Parameters
    number: Integer - The number to be converted to a string ordinal
Return Value
    String - Returns a string ordinal based off of the number.
Constraints
    0 ≤ number ≤ 10000

Examples
number 	Return Value
1 	"1st"
2 	"2nd"
3 	"3rd"
4 	"4th"
21 	"21st"
 */
public class ConvertNumberToOrdinal {
    private static Map<Integer,String> ordinals=new HashMap<Integer,String>();
    public static void numberToOrdinalMethod() {
        // test input
        Integer number=21;
        System.out.println(numberToOrdinal(number));
    }


    public static String numberToOrdinal(Integer number) {

        //initialise ordinals
        intialiseOrdinals();

        // handle default case
        if(number!=0){
            String lastOrdinal=calculateLastOrdinal(number);
            String numString=number.toString();
            // replace last digit with lastOrdinal
            return numString.substring(0,numString.length()-1)+lastOrdinal;
        }
        return "0";
    }

    // Calculates Ordinals for single as well as teen digits
    private static String calculateLastOrdinal(Integer number) {
        String lastOrdinal="";
        //get last digit
        int lastDigit=number%10;

        //check for teen digits
        int lastTwoDigits=number%100;
        String lastTwoString=String.valueOf(lastTwoDigits);
        boolean teen=false;
        if(lastTwoString.length()>1){
            char lastButOne=String.valueOf(lastTwoDigits).charAt(0);
            teen=(lastButOne=='1')?true:false;
        }

        // logic to append last ordinal
        if(teen){
            lastOrdinal=lastDigit+"th";
        }else if(ordinals.get(lastDigit)!=null){
            lastOrdinal=ordinals.get(lastDigit);
        }else{
            lastOrdinal=lastDigit+"th";
        }
        return lastOrdinal;
    }

    //Initialise Ordinals
    private static void intialiseOrdinals() {
        ordinals.put(1,"1st");
        ordinals.put(2,"2nd");
        ordinals.put(3,"3rd");
    }
}
