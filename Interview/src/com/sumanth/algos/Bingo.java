package com.sumanth.algos;

import java.util.Arrays;
/*
Brilliant bingo is a game invented by a team of brilliant people in a company.
The rules are simple, everyone playing the game gets a random number in the range 1 to 9999
and in each round of the game the players have to multiply their number with the round number.
The game stops when a player gets all the digits from 0 to 9 in all the rounds that they
have played combined and it’s a brilliant bingo.
Write a program that takes a random number as input and prints the number of rounds it
would take to win brilliant bingo with that number.

Input
Single line with the integer less than 9999.

Output
The number of rounds to hit the Bingo.

Example:
Let’s say Nikki is playing the game and gets the random number 7892 then it will take Nikki 5 rounds
to get all the number digits 0 to 9.

Round 1: 7892*1 = 7892
Round 2: 7892*2 = 15784
Round 3: 7892*3 = 23676
Round 4: 7892*4 = 31568
Round 5: 7892*5 = 39460
 */
public class Bingo {
    private static int[] allNumbersBitArray = new int[10];

    public static void checkAllNUmbers(){
        String input="Hello";
        //initialise to zero
        Arrays.fill(allNumbersBitArray, 0);
        
        //Edge case
        String regex = "\\d+";
        if(input.matches(regex)){
            //play game
            int round=playGame(input);
            System.out.println("Number of Rounds to get all digits 0 to 9: "+round);
        }else{
            System.out.println("Invalid Input");
        }

    }

    // Bingo Game
    private static int playGame(String input) {
        int intValue=Integer.valueOf(input);
        int round = 0;
        int tempResult=0;
        while(ifAllNumbersAreSet()==0){
            round++;
            tempResult=intValue*round;
            char[] inputChars=String.valueOf(tempResult).toCharArray();
            for (char ele: inputChars) {
                int val=Integer.valueOf(ele)-'0';
                allNumbersBitArray[val]=1;
            }
        }
        return round;
    }

    // Algorithm which checks all numbers are present
    public static int ifAllNumbersAreSet(){
        int product=1;
        for(int ele:allNumbersBitArray){
            product=product*ele;
        }
        return product;
    }
}
