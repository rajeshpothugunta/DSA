package com.coding.patterns;

public class Main {
    public static void main(String[] args) {
        pattern7(5);
        //pattern2(5);
        //pattern3(5);
        //pattern9(5);

    }

    static void pattern1(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n-row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n){
        for (int row = 0; row < 2*n; row++) {
            int totalColInRow = row > n ? 2*n - row : row;
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for (int row = 0; row < 2*n; row++) {
            int totalColInRow = row > n ? 2*n - row : row;
            int spaces = n-totalColInRow;
            for (int col = 0; col < spaces; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for (int row = 1; row <= n; row++) {

            int spaces = n-row;

            for (int col = 0; col < spaces; col++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col+" ");
            }
            for (int col = 2; col <= row ; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern7(int n){
        for (int row = 0; row < 2*n; row++) {
            int totalColInRow = row > n ? 2*n - row : row;
            int spaces = n-totalColInRow;
            //print spaces
            for (int col = 0; col < spaces; col++) {
                System.out.print("  ");
            }
            for (int col = totalColInRow; col >= 1; col--) {
                System.out.print(col+" ");
            }
            for (int col = 2; col <= totalColInRow ; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern8(int n) {
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
    static void pattern9(int n) {
        int originalN = n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }

}
