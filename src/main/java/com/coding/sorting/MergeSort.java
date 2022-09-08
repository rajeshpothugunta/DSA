package com.recursion;

public class MergeSort {
	public static void main(String[] args) {
		int arr[]= {6,3,9,5,2,8};
		int e = arr.length;
		mergeSort(arr,0,e-1);
		for(int i=0;i<e;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void mergeSort(int arr[], int s, int e) {
		//base case
		if(s>=e) {
			return;
		}
		int mid=(s+e)/2;
		mergeSort(arr,s,mid);
		mergeSort(arr,mid+1,e);
		merge(arr,s,mid,e);
		
	}
	public static void merge(int arr[], int s, int mid, int e) {
		//create temp array
		int brr[] = new int[e-s+1];
		int i=s;
		int j=mid+1;
		//index of temp array
		int k=0;
		
		//copy values to temp array
		while(i<=mid && j<=e) {
			if(arr[i]<=arr[j]) {
				brr[k]=arr[i];
				i++;
			}
			else {
				brr[k]=arr[j];
				j++;
			}
			k++;			
		}
		//if still elements in 1st array
		while(i<=mid) {
			brr[k]=arr[i];
			k++;i++;
		}
		//if still elements in 2nd rray
		while(j<=e) {
			brr[k]=arr[j];
			k++;j++;
		}
		//copy back to original array
		for(int idx1=0,idx2=s;idx1<brr.length;idx1++,idx2++) {
			arr[idx2]=brr[idx1];
		}
	}

}
