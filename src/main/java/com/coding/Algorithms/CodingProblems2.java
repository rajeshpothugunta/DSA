package com.sdet;

import java.lang.Math;

public class CodingProblems2 {
	public static void main(String[] args) {
		int num = -5;
	    System.out.print("Binary of num 59 is: ");
	    reverse(DecimalToBinary(num));
}
	
	 static String DecimalToBinary(int num)
	  {
	    String str = "";
	    while (num > 0) {
	      if ((num & 1) == 1) // 1
	        str += '1';
	      else // 0
	        str += '0';
	      num >>= 1; // Right Shift by 1
	    }
	    return str;
	  }
	 
	  // reverse the string
	  static void reverse(String str)
	  {
	    for (int i = str.length() - 1; i >= 0; i--)
	      System.out.print(str.charAt(i));
	  }
	  }
