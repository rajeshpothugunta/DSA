package com.sdet;

public class Bitwiseop {
	public static void main(String[] args) {
		solveMe();

}

	public static void solveMe() {
		
		int a = 4;
		int b = 6;
		System.out.println("a&b: "+ (a&b));
		System.out.println("a|b: "+ (a|b));
		System.out.println("~a: "+ (~a));
		System.out.println("a^b: "+ (a^b));
		System.out.println((17>>1));
		System.out.println((17>>2));
		System.out.println((19<<1));
		System.out.println((19<<2));

		
	}
}