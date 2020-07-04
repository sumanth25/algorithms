package com.sumanth.algos;
/*
Students in a university have applied for a job in a company named ABC. Before their face-to-face
interview rounds, all the students have to take a pre-screening multiple choice test and score more
than 50% in that test to qualify for the further interview rounds.
Jacky from the talent acquisition team of ABC company manages the pre-screening test for all the
students. The university has assigned a classroom for the pre-screening test. The seating capacity
of the classroom is always less than the number of students applied for the job and hence the test
has to be taken in different batches to ensure that all the students get to take the test.
To manage time better, Jacky aims to place the maximum number of students in the classroom together
for their pre-screening test. Desks in this classroom are arranged in an R number of rows and C
number of columns. One desk can be used by one student. Few desks are broken and cannot be used.
Jacky fears that the students might cheat from other students sitting near them. (This is obviously
not true, but she is not convinced). So, to ensure that the students do not cheat, she needs to place them in a way that they cannot see the answers of any other students.
A student can see the answers of the students sitting to the left, right, upper left and upper
right, but he/she cannot see the answers of the student sitting in directly in front or behind
him/her.

For example, the student E can see the answers of the student A, student C, student D, and
student F but not the student B. Refer to the figure below.

Write a program that would suggest the maximum number of students that can give the
pre-screening test together without cheating.
Input
The first line of the input indicates R number of rows in the classroom and the second
line indicates C number of desks in each row. In the subsequent lines, if the desk is broken,
then it is denoted by a “+” character otherwise it is denoted by a “.” character.
Output
The maximum number of students that can give the test together without cheating.
 */
public class DeskArrangement {

    public static void maxStudentsWithoutCheating(){
        int R=2;
        int C=3;
        String r1="+.+";
        String r2="+.+";
        char[][] deskMatrix = buildDeskArray(R, C, r1, r2);
        int maxStudents=calculateMaxStudentsWithoutCheating(deskMatrix, R, C);
        System.out.println("Maximum number of students without cheating "+maxStudents);
    }

    // Algorithm to consider alternate columns as empty
    private static int calculateMaxStudentsWithoutCheating(char[][] deskMatrix,int r, int c) {
        int maxStudents=0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(j%2==0){
                    if(deskMatrix[i][j]!='+'){
                        maxStudents++;
                    }
                }
            }
        }
        return maxStudents;
    }

    // build desk matrix
    private static char[][] buildDeskArray(int r, int c, String r1, String r2) {
        char[] r1Arr=r1.toCharArray();
        char[] r2Arr=r2.toCharArray();
        char[][] deskMatrix=new char[r][c];
        deskMatrix[0]=r1Arr;
        deskMatrix[1]=r2Arr;
        return deskMatrix;
    }
}
