package com.recursion;

public class LinearSearch {
	public static void main(String[] args) {
	int arr[]= {10,20,30,40,50};
	int size = arr.length;
	int key=25;
	boolean ans=linearSearch(arr,size,key);
	System.out.println("element found is:"+ans);
	}

	public static boolean linearSearch(int arr[],int size,int key) {
		if(size==0)
			return false;
		if(arr[size-1]==key)
			return true;
		return linearSearch(arr,size-1,key);
	}

}
