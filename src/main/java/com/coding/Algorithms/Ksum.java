package com.coding.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ksum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums,0,4,target);
    }
    private static List<List<Integer>> kSum (int[] nums, int start, int k, int target) {
        int len=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        if(k==2){
            res=twoSum(nums,start,len,target);
            return res;
        }
        for (int i = start; i < len - (k - 1); i++) {
            //use current number to reduce ksum into k-1sum
            //Recursive call to KSum with k-1
            List<List<Integer>> temp = kSum(nums,i+1,k-1,target - nums[i]);
            if(temp != null){
                //add previous results
                /************************************************************************/
                //Add the number which called KSum with k-1
                //For example if -2 called KSum_Recursion(k=2 & target=2)
                //KSum_Recursion(k=2 & target=2) would come back with [[1, 1], [0, 2]]
                //We would update those list such that they become [[-2, 1, 1], [-2, 0 ,2]]
                /************************************************************************/
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
            while (i < len-1 && nums[i] == nums[i+1]) {
                //skip duplicated numbers
                i++;
            }
        }

        return res;

    }
    /************************************************************************/
    //Two sum approach using 2 pointer algorithm
    //Add the 2 numbers from those pointers
    //  If sum is less than target then do left++
    //  else If sum is greater than target then do right--
    /************************************************************************/

    private static List<List<Integer>> twoSum(int[] nums,int start,int len,int target){
        List<List<Integer>> twosumList=new ArrayList<>();
        int left = start, right = len - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                List<Integer> path = new ArrayList<Integer>();
                path.add(nums[left]);
                path.add(nums[right]);
                twosumList.add(path);
                //Handle duplicate combinations
                //Remember array is sorted
                while(left < right && nums[left] == nums[left + 1]) left++;
                //Handle duplicate combinations
                //Remember array is sorted
                while(left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            } else if (sum < target) { //move left
                left++;
            } else { //move right
                right--;
            }
        }
        return twosumList;
    }

    public static void main(String[] args) {
        int[] nums={1,0,-1,0,-2,2};
        System.out.println(fourSum(nums,0));
    }
}
