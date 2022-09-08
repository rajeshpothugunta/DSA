package com.sdet;

import java.util.Scanner;
import java.lang.Math;

public class CodingProblems {
	public static void main(String[] args) {
		solveMe();
}
	
	public static void solveMe() {
		Scanner input = new Scanner(System.in);
    	
        System.out.print("Enter an integer: ");
        int n = input.nextInt();
        if(n>=0)
        	System.out.print("0");
        else
        	System.out.print("1");

        
        for (int i = 30; i >= 0; i--) {
            //int k = n >> i;
            if ((n&1<<i) > 0)
                System.out.print("1");
            else
                System.out.print("0");
        }
        System.out.println();
        System.out.println(Integer.toBinaryString(-5));

		
	}
}
