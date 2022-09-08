package com.sdet;

import java.util.Scanner;

public class Array_Programs {
	
	public static void findLeader(int[] a) {
		// Write your code here.
		int largest = Integer.MIN_VALUE;
		int b[] = new int[a.length];
		int j=0;
		for(int i=a.length-1;i>=0;i--) {
			if(a[i]>largest) {
				largest=a[i];
				System.out.println(a[i]+"");
				b[j++]=a[i];
				
			}
		}
		System.out.println();
		for(j=j-1;j>=0;j--) {
			System.out.println(b[j]+"");
		}

	}
	
	public static void main(String[] args) {
		int a[] = {2,7,6,4,1,3};
		findLeader(a);
	}
	
}
