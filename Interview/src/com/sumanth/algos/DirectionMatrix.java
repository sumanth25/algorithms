package com.sumanth.algos;

import java.util.Scanner;
/*
Problem: Fetch element based on directions in a square matrix
Should also ignore out of matrix directions
Input (size, matrix data, moves, directions):
4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
6
RIGHT
DOWN
RIGHT
DOWN
LEFT
UP
Output:
6
 */
public class DirectionMatrix {
    public static void directionMatrix() {
        System.out.println("Enter input values for direction matrix");
        Scanner in = new Scanner(System.in);

        // Declare the variable
        int n;

        // Read the variable from STDIN
        n = in.nextInt();

        //create matrix from input
        int matrix[][]=new int[n][n];
        matrix=populateSqMatrix(n,in,matrix);

        //No of cursor moves
        int moves=in.nextInt();

        //retrieve element from moves
        int element=retrieveElement(matrix,moves,in,n);

        // Output the variable to STDOUT
        System.out.println(element);
    }

    // method to retrieve the element based on direction
    private static int retrieveElement(int[][] matrix, int moves, Scanner in, int n) {
        int i=0;
        int j=0;
        for (int m = 0; m < moves; m++) {
            String direction=in.next();
            switch(direction)
            {
                case "RIGHT":j=((j+1)<n)?j+1:j;
                    break;
                case "LEFT":j=((j-1)>=0)?j-1:j;
                    break;
                case "DOWN":i=((i+1)<n)?i+1:i;
                    break;
                case "UP":i=((i-1)>=0)?i-1:i;
                    break;
                default: System.out.println("Ivalid direction input");
            }
        }
        if(i>=0&&j>=0){
            return matrix[i][j];
        }else{
            System.out.println("Element not found");
        }
        return 0;
    }

    // method to populate the matrix
    private static int[][] populateSqMatrix(int n, Scanner in, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]=in.nextInt();
            }
        }
        return matrix;
    }
}
