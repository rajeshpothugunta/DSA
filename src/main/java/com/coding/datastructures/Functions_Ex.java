package com.sdet;

import java.util.Scanner;

public class Functions_Ex {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	System.out.print("Enter n,r : ");
        int n = input.nextInt();
        int r = input.nextInt();
        System.out.println("Answer for nCr is : "+ nCr(n,r));

}

	static int Factorial(int n) {
		int fact  = 1;
		for(int i=1;i<=n;i++) {
			fact=fact*i;		
		}
		return fact;
	}
	
	static int nCr(int n, int r) {
		int ans = (Factorial(n))/(Factorial(n-r)*Factorial(r));
		return ans;
	}
	

}
