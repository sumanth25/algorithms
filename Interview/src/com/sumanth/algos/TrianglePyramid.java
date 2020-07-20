package com.sumanth.algos;
/*
    Print Pyramids
 */
public class TrianglePyramid {
    public static void generate() {
       generateRightAngledPyramid(10);
       generateRotatedightAngledPyramid(10);
       generatePyramid(10);
    }

    // Normal Pyramid
    private static void generatePyramid(int n) {
        for (int i = 0; i < n; i++) {
            // print spaces
            for (int j = n-i; j > 1; j--) {
                System.out.print(" ");
            }

            // print *
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    // 180deg rotated Right Angled Pyramid
    private static void generateRotatedightAngledPyramid(int n) {
        for (int i = 0; i < n; i++) {
            // print spaces
            for (int j = 2*(n-i-1); j >=0; j--) {
                System.out.print(" ");
            }

            // print *
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    // Right Angled Pyramid
    private static void generateRightAngledPyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}
