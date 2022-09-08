package com.recursion;

public class BinarySearch {
	public static void main(String[] args) {
	int arr[]= {10,20,30,40,50};
	int size = arr.length;
	int key=22;
	int s=0;
	int e=size-1;
	boolean ans=binarySearch(arr,s,e,key);
	System.out.println("element found is:"+ans);
	}

	public static boolean binarySearch(int arr[],int s,int e,int key) {
		//base case
		if(s>e)
			return false;
		int mid=s+(e-s)/2;
		if(arr[mid]==key)
			return true;
		if(arr[mid]>key)
			return binarySearch(arr,s,mid-1,key);
		else
			return binarySearch(arr,mid+1,e,key);
	}

}
