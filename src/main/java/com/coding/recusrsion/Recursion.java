package com.coding.recusrsion;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {

    }
    //factorial of a number
    static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    //fibonacci series
    static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    //sum of n natural numbers
    static int sum(int n){
        if(n==0){
            return 0;
        }
        return n+sum(n-1);
    }
    //find power of a number
    static int power(int n, int p){
        if(p==0){
            return 1;
        }
        return n*power(n,p-1);
    }
    //fast power of a number
    static int fastPower(int n, int p){
        if(p==0){
            return 1;
        }
        int subProblem=fastPower(n,p/2);
        if(p%2==0){
            return subProblem*subProblem;
        }else{
            return n*subProblem*subProblem;
        }
    }
    //revese the array
    static void reverse(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        reverse(arr,start+1,end-1);
    }
    //unique paths in a grid
    static int uniquePaths(int m, int n){
        if(m==1 || n==1){
            return 1;
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
    //sum of digits of a number
    static int sumOfDigits(int n){
        if(n==0){
            return 0;
        }
        return n%10+sumOfDigits(n/10);
    }
    //Generate subsets of array
    public static List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(current);
            return;
        }

        // Generate subsets without including the current element
        generateSubsets(index + 1, nums, current, subsets);

        // Generate subsets including the current element
        List<Integer> newSubset = new ArrayList<>(current);
        newSubset.add(nums[index]);
        generateSubsets(index + 1, nums, newSubset, subsets);
    }

    //Generate subsets of string
    public static List<String> getSubsets(String str) {
        List<String> subsets = new ArrayList<>();
        generateSubsets(0, str, "", subsets);
        return subsets;
    }

    private static void generateSubsets(int index, String str, String current, List<String> subsets) {
        if (index == str.length()) {
            subsets.add(current);
            return;
        }

        // Generate subsets without including the current character
        generateSubsets(index + 1, str, current, subsets);

        // Generate subsets including the current character
        generateSubsets(index + 1, str, current + str.charAt(index), subsets);
    }




}
