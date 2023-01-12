package com.coding.arrays;

import java.util.*;

public class ArrayPrograms {
    public static void main(String[] args) {
        int[] a = {2,3,3,3,3,3};
        int[] b = removeDuplicates(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }


    }
    //delete an element from an array
    static int[] delete(int[] arr, int index){
        int[] newArr=new int[arr.length-1];
        for (int i = 0; i < index; i++) {
            newArr[i]=arr[i];
        }
        for (int i = index+1; i < arr.length; i++) {
            newArr[i-1]=arr[i];
        }
        return newArr;
    }
    //second largest element in an array
    static int secondLargest(int[] arr){
        int largest=arr[0];
        int secondLargest=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>secondLargest){
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }
    //Third largest element in an array
    static int thirdLargest(int[] arr){
        int largest=arr[0];
        int secondLargest=arr[0];
        int thirdLargest=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>largest){
                thirdLargest=secondLargest;
                secondLargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>secondLargest){
                thirdLargest=secondLargest;
                secondLargest=arr[i];
            }
            else if(arr[i]>thirdLargest){
                thirdLargest=arr[i];
            }
        }
        return thirdLargest;
    }
    //remove duplicates from an array
    static int[] removeDuplicates(int[] arr){
        int[] newArr=new int[arr.length];
        int j=0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]!=arr[i+1]){
                newArr[j++]=arr[i];
            }
        }
        newArr[j++]=arr[arr.length-1];
        return newArr;
    }
    //reverse an array
    static int[] reverse(int[] arr){
        int[] newArr=new int[arr.length];
        int j=0;
        for (int i = arr.length-1; i >=0; i--) {
            newArr[j++]=arr[i];
        }
        return newArr;
    }
    //find leaders in an array
    static void findLeaders(int[] arr){
        int largest=arr[arr.length-1];
        System.out.println(largest);
        for (int i = arr.length-2; i >=0; i--) {
            if(arr[i]>largest){
                largest=arr[i];
                System.out.println(largest);
            }
        }
    }
    //Maximum subarray sum
    static int maxSubarraySum(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum>maxSum){
                maxSum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }

    //frequency of each element in an array using hashmaps
    static void frequency(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    //max consecutive 1's in an array
    static int maxConsecutiveOnes(int[] arr){
        int maxCount=0;
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                count++;
            }
            else{
                count=0;
            }
            if(count>maxCount){
                maxCount=count;
            }
        }
        return maxCount;
    }

    //move all zeroes to the end of an array
    static int[] moveZeroes(int[] arr){
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                arr[j++]=arr[i];
            }
        }
        while(j<arr.length){
            arr[j++]=0;
        }
        return arr;
    }
    //Minimum sum subarray
    static int minSumSubarray(int[] arr){
        int minSum=Integer.MAX_VALUE;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum<minSum){
                minSum=sum;
            }
            if(sum>0){
                sum=0;
            }
        }
        return minSum;
    }
    //subarray with given sum using Hashmaps
    static void subarraySum(int[] arr,int sum){
        HashMap<Integer,Integer> map=new HashMap<>();
        int currSum=0;
        for (int i = 0; i < arr.length; i++) {
            currSum+=arr[i];
            if(currSum==sum){
                System.out.println("Sum found between indexes 0 to "+i);
                return;
            }
            if(map.containsKey(currSum-sum)){
                System.out.println("Sum found between indexes "+(map.get(currSum-sum)+1)+" to "+i);
                return;
            }
            map.put(currSum,i);
        }
        System.out.println("No subarray with given sum exists");
    }
    //count subarrays with given sum
    static int countSubarrays(int[] arr,int sum){
        HashMap<Integer,Integer> map=new HashMap<>();
        int currSum=0;
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            currSum+=arr[i];
            if(currSum==sum){
                count++;
            }
            if(map.containsKey(currSum-sum)){
                count+=map.get(currSum-sum);
            }
            if(map.containsKey(currSum)){
                map.put(currSum,map.get(currSum)+1);
            }
            else{
                map.put(currSum,1);
            }
        }
        return count;
    }

    //subarrays with 0 sum
    static void subarraysWithZeroSum(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        int currSum=0;
        for (int i = 0; i < arr.length; i++) {
            currSum+=arr[i];
            if(currSum==0){
                System.out.println("Subarray found between indexes 0 to "+i);
            }
            if(map.containsKey(currSum)){
                System.out.println("Subarray found between indexes "+(map.get(currSum)+1)+" to "+i);
            }
            else{
                map.put(currSum,i);
            }
        }
    }

    //largest subarray with 0 sum
    static int largestSubarraySum(int[] arr){
        int maxLen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int currSum=0;
        for (int i = 0; i < arr.length; i++) {
            currSum+=arr[i];
            if(currSum==0){
                maxLen=i+1;
            }
            if(map.containsKey(currSum)){
                maxLen=Math.max(maxLen,i-map.get(currSum));
            }
            else{
                map.put(currSum,i);
            }
        }
        return maxLen;
    }
    //Transpose of a matrix
    static void transpose(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
    //Rotate a matrix by 90 degrees
    static void rotate(int[][] arr){
        transpose(arr);
        //mirror the matrix
        for (int i = 0; i < arr.length; i++) {
            int low=0;
            int high=arr[0].length-1;
            while(low<high){
                int temp=arr[i][low];
                arr[i][low]=arr[i][high];
                arr[i][high]=temp;
                low++;
                high--;
            }
        }
    }
    //search in a row wise and column wise sorted matrix
    static boolean search(int[][] arr,int target){
        int row=0;
        int col=arr[0].length-1;
        while(row<arr.length && col>=0){
            if(arr[row][col]==target){
                return true;
            }
            else if(arr[row][col]>target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
    // maximum length of a contiguous subarray with an equal number of 0 and 1
    static int maxLength(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                count--;
            }
            else{
                count++;
            }
            if(count==0){
                maxLen=i+1;
            }
            if(map.containsKey(count)){
                maxLen=Math.max(maxLen,i-map.get(count));
            }
            else{
                map.put(count,i);
            }
        }
        return maxLen;
    }
    //majority element

    //majority element using moore's voting algorithm
    static int majorityElementMoore(int[] arr){
        int res=0;
        int count=1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[res]==arr[i]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                res=i;
                count=1;
            }
        }
        count=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[res]==arr[i]){
                count++;
            }
        }
        if(count<=arr.length/2){
            return -1;
        }
        return arr[res];
    }
    //Rotate an array by k elements
    static void rotate(int[] arr,int k){
        k=k%arr.length;
        if(k<0){
            k=k+arr.length;
        }
        reverse(arr,0,arr.length-k-1);
        reverse(arr,arr.length-k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    static void reverse(int[] arr,int low,int high){
        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }
    //find maximum j - i subjected to the constraint of Arr[i] <= Arr[j]
    static int maxIndexDiff(int[] arr){
        int[] leftMin=new int[arr.length];
        int[] rightMax=new int[arr.length];
        leftMin[0]=arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMin[i]=Math.min(arr[i],leftMin[i-1]);
        }
        rightMax[arr.length-1]=arr[arr.length-1];
        for (int i = arr.length-2; i >=0; i--) {
            rightMax[i]=Math.max(arr[i],rightMax[i+1]);
        }
        int i=0;
        int j=0;
        int maxDiff=-1;
        while(i<arr.length && j<arr.length){
            if(leftMin[i]<=rightMax[j]){
                maxDiff=Math.max(maxDiff,j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return maxDiff;
    }
    //Two sum with multiple solutions
    static void twoSum(int[] arr,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(target-arr[i])){
                System.out.println(arr[i]+" "+(target-arr[i]));
            }
            else{
                map.put(arr[i],i);
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate triplets with the same first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Find all pairs with sum equals to target - nums[i]
            int newTarget = target - nums[i];
            List<List<Integer>> pairs = twoSumSorted(Arrays.copyOfRange(nums, i + 1, nums.length), newTarget);
            for (List<Integer> pair : pairs) {
                triplets.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
            }
        }

        return triplets;
    }
    //code for two sum sorted array
    public static List<List<Integer>> twoSumSorted(int[] nums, int target) {
        List<List<Integer>> pairs = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                pairs.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }
    //Intersection of two sorted arrays
    static void intersection(int[] arr1,int[] arr2){
        int i=0;
        int j=0;
        while(i<arr1.length && j<arr2.length){
            if(i>0 && arr1[i]==arr1[i-1]){
                i++;
                continue;
            }
            if(arr1[i]<arr2[j]){
                i++;
            }
            else if(arr1[i]>arr2[j]){
                j++;
            }
            else{
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
    }
    //Union of two sorted arrays
    static void union(int[] arr1,int[] arr2){
        int i=0;
        int j=0;
        while(i<arr1.length && j<arr2.length){
            if(i>0 && arr1[i]==arr1[i-1]){
                i++;
                continue;
            }
            if(j>0 && arr2[j]==arr2[j-1]){
                j++;
                continue;
            }
            if(arr1[i]<arr2[j]){
                System.out.println(arr1[i]);
                i++;
            }
            else if(arr1[i]>arr2[j]){
                System.out.println(arr2[j]);
                j++;
            }
            else{
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
        while(i<arr1.length){
            if(i==0 || arr1[i]!=arr1[i-1]){
                System.out.println(arr1[i]);
            }
            i++;
        }
        while(j<arr2.length){
            if(j==0 || arr2[j]!=arr2[j-1]){
                System.out.println(arr2[j]);
            }
            j++;
        }
    }
    //find intersection of two unsorted arrays
    static void intersectionUnsorted(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i],1);
        }
        for (int i = 0; i < arr2.length; i++) {
            if(map.containsKey(arr2[i])){
                System.out.println(arr2[i]);
                map.remove(arr2[i]);
            }
        }
    }
    //sort an array of 0s,1s
    static void sortZeroOne(int[] arr){
        int i=0;
        int j=0;
        while(i<arr.length){
            if(arr[i]==0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
            else{
                i++;
            }
        }
    }
    //sort an array of 0s,1s,2s
    /*This program uses three pointers to sort the array. The low pointer points to the first element that is not 0, the high pointer points
     to the last element that is not 2, and the i pointer is used to iterate through the array. If the element at the i pointer is 0,
     it is swapped with the element at the low pointer
     */
    public static void sort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int i = 0;

        while (i <= high) {
            if (nums[i] == 0) {
                // Swap nums[i] with nums[low]
                int temp = nums[i];
                nums[i] = nums[low];
                nums[low] = temp;
                low++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // Swap nums[i] with nums[high]
                int temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
    //find duplicate in an array of N+1 integers

    /*This program uses the fact that the elements in the array are between 1 and n, where n is the length of the array. It iterates through the array and uses the value
     of each element as an index to mark the element at that index as visited.
     If the element at that index has already been visited, it means that the element is a duplicate.
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicates.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }

        return duplicates;
    }


}
