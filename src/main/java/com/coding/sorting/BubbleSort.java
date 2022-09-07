package com.coding.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,6,1,4,6,8,9};
        bubbleSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    private static void bubbleSort(int[] arr) {
        //Largest element will go to right place
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
