package com.recursion;


public class SortRecursion {
	public static void main(String[] args) {
		int arr[]= {10,20,30,4,50};
		int size = arr.length;
        if (isSorted(arr, size) != 0)
            System.out.println("Yes");
        else
            System.out.println("No");
}

	
	public static int isSorted(int arr[], int size) {
        //base case
		if(size==0 || size==1)
			return 1;
		if(arr[size-1]<arr[size-2])
			return 0;
		return isSorted(arr,size-1);

	}
}