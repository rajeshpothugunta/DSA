package com.sdet;
import java.util.Scanner;
public class Patterns {
	public static void main(String[] args) {
		solveMe();
	}
	
	public static void solveMe() {
		
		Scanner input = new Scanner(System.in);
    	
        System.out.print("Enter an integer: ");
        int n = input.nextInt();
        int i =1;
          while(i<=n) {
        	//print spaces
         	int space = i-1;
         	while(space>0) {
         		System.out.print(" ");
         		space--;
        	}
         	//print stars
         	int col = 1;
         	while(col<=n-i+1) {
         		System.out.print("*");
         		col++;
         	}
        	System.out.println();
        	
        	i++;
        }
		
		
	}
}