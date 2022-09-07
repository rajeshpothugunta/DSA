package com.coding.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2,6,1,4,6,8,9};
        selectionSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    private static void selectionSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr,min,i);
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
