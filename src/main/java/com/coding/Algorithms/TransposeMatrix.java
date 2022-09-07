package com.coding.Algorithms;

public class TransposeMatrix {
    public static int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        System.out.println(R+" "+C);
        int[][] B = new int[C][R];
        for (int i = 0; i < C; i++)
            for (int j = 0; j < R; j++)
                B[i][j] = A[j][i];

        return B;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6}};
        System.out.println(transpose(A));

    }
}
