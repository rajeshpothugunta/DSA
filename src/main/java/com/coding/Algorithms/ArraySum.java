package com.recursion;

public class ArraySum {
	public static void main(String[] args) {
		int arr[]= {10,20,30,40,50};
		int size = arr.length;
		int sum=getSum(arr,size);
		System.out.println("sum is:"+sum);
	}
	
	
	public static int getSum(int arr[], int size) {
		if(size==0)
			return 0;
		return getSum(arr, size-1 ) + arr[size-1];
		
	}
}
