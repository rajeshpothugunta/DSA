package com.coding.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2,6,1,4,6,8,9};
        insertionSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
    private static void insertionSort(int[] arr) {
        for(int i=1;i<arr.length-1;i++){
            int j=i-1;
            int temp =arr[i];
            for(;j>=0;j--){
                if(temp<arr[j])
                    arr[j+1]=arr[j];
                else
                    break;
            }
            arr[j+1]=temp;
        }
    }
}
