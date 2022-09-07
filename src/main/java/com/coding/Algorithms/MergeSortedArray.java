package com.coding.Algorithms;

public class MergeSortedArray {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr=new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                arr[k++]=nums1[i++];
            }
            else{
                arr[k++]=nums2[j++];
            }
        }
        //copy first array k elemnts
        while(i<m){
            arr[k++]=nums1[i++];
        }
        //copy second array k elemnts
        while(j<n){
            arr[k++]=nums2[j++];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3};
        int[] nums2={2,5,6};
        int m=nums1.length;
        int n=nums2.length;
        int[] ans= new int[m+n];
        ans=merge(nums1,m,nums2,n);
        for(int e:ans)
            System.out.print(e+" ");
    }
}
