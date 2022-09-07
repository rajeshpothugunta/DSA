package com.coding.Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 2, 8, 4};

        findTriplet(arr, 15);
    }

    public static void findTriplet(int[] arr, int sum) {
        int n = arr.length;
        if (n < 3) {
            System.out.println("No triplets found");
        }
        for (int i = 0; i < n - 2; i++) {
            int remainingSum = sum - arr[i];
            List<Pair> pairList = findPair(arr, i + 1, n, remainingSum);
            for (Pair p: pairList) {
                System.out.println("Triplet found: [" + arr[i] + "," + p.x + "," + p.y + "]");
            }
        }
    }

    public static List<Pair> findPair(int[] arr, int left, int right, int sum) {
        List <Pair> pairList = new ArrayList<>();
        HashSet<Integer> visitedElements = new HashSet <> ();
        for (int i = left; i < right; i++) {
            int curElement = arr[i];
            int searchElement = sum - arr[i];
            if (visitedElements.contains(searchElement)) {
                pairList.add(new Pair(searchElement, curElement));
            } else {
                visitedElements.add(curElement);
            }
        }
        return pairList;
    }
}
 class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}