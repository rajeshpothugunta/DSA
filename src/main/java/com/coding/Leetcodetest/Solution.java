package com.coding.Leetcodetest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int i,j=0;
        //process first window
        for (i = 0; i < k; i++) {
            //remove waste element if exists in first window
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        //process rest of elements
        //from nums[k] to nums[n-1]
        for(;i<n;i++){
            //add max element
            ans[j++]=nums[dq.peek()];
            //remove element which is out of window
            while(!dq.isEmpty() && dq.peek()<=i-k)
                dq.removeFirst();
            //remove useless elemet
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        //max element of last window
        ans[j++]=nums[dq.peek()];
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1,3,-1,-3,5,3,6,7};
        int[] ans = maxSlidingWindow(nums,3);
        for(int i:ans){
            System.out.print(i+" ");
        }


    }
}
