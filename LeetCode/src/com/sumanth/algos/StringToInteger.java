package com.sumanth.algos;

import java.util.regex.Pattern;

/*
String to Integer (atoi)
Medium

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first
non-whitespace character is found. Then, starting from this character, takes an optional
initial plus or minus sign followed by as many numerical digits as possible, and interprets
them as a numerical value.
 */
public class StringToInteger {
    public static void stringToIntegerAlgo(){
        String x="  -42";
        int result = myAtoi(x);
        System.out.println(result);
    }

    /*
     *   Algorithm
     */
    public static int myAtoi(String str) {
        String[] arr = str.split(" ");
        //checks for +,-, ints and decimals
        String regex = "^[+-]?\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        int res=0;

            for (String val : arr) {
                if (pattern.matcher(val).matches()) {
                    try {
                        //floor of decimal
                        if(val.contains(".")){
                            val=val.substring(0,val.indexOf("."));
                        }
                         res = Integer.parseInt(val);
                        return res;
                    }catch (NumberFormatException e){
                        //Max or Min of Integer Limit on exceeding
                        if(val.charAt(0)=='-'){
                            return Integer.MIN_VALUE;
                        }else{
                            return Integer.MAX_VALUE;                        }
                    }
                } else if (!val.equals("")) {
                    //All non-numeric words
                    return 0;
                }
            }

        return res;
    }
}
