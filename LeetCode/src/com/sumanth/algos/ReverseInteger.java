package com.sumanth.algos;
/*
 Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.
 */
public class ReverseInteger {
    public static void reverseIntegerAlgo(){
        int x=-321;
        int result = reverse(x);
            System.out.println(result);
    }

    /*
     *   Algorithm
     */
    public static int reverse(int x) {
        StringBuffer input = new StringBuffer();
        input.append(x);
        input.reverse();
        String output="";

        if(input.charAt(input.length()-1)=='-'){
            output=output+"-"+input.substring(0,input.length()-1);
        }
        else{
            output=input.toString();
        }
        try{
            return Integer.parseInt(output);
        }catch (NumberFormatException e){
            return 0;
        }
    }
}
