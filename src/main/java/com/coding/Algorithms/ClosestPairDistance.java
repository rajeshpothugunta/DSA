package com.coding.Algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class ClosestPairDistance {
    public static double calculateCase3(ArrayList<Point> arr,int size, double minDistance){
        double minValue=minDistance;
        for(int i=0;i<size;i++){
            //why upto 76 points
            //https://math.stackexchange.com/questions/45776/closest-pair-of-points-algorithm#:~:text=Figure%20%2333.11%3A%20Key%20concepts%20in,rectangle%20centered%20at%20line%201
            for(int j=i+1;j<Math.min(size,i+1+7);j++){
                minValue=Math.min(minValue,distance(arr.get(i),arr.get(j)));
            }
        }
        return minValue;
    }
    public static double bruteForce(ArrayList<Point> arrX,int count){
        double result=Integer.MAX_VALUE;
        for (int i=0;i<count;i++){
            for (int j=i+1;j<count;j++){
                result=Math.min(result,distance(arrX.get(i),arrX.get(j)));
            }
        }
        return result;
    }
    public static double closestRecursive(ArrayList<Point> arrX,ArrayList<Point> arrY,int count){
        if(count<=3)
            return bruteForce(arrX,arrX.size());
        int mid=count/2;
        Point midPoint=arrX.get(mid);

        ArrayList<Point> newArrX1=new ArrayList<>();
        ArrayList<Point> newArrX2=new ArrayList<>();
        for (int i=0;i<mid;i++){
            newArrX1.add(arrX.get(i));
        }
        for (int i=0;i<arrX.size();i++){
            newArrX2.add(arrX.get(i));
        }
        double distanceLeft=closestRecursive(newArrX1,arrY,mid);
        double distanceRight=closestRecursive(newArrX2,arrY,count-mid);

        double minDistance=Math.min(distanceLeft,distanceRight);

        ArrayList<Point> arrCase3=new ArrayList<>();
        for (int i=0;i<count;i++){
            if (Math.abs(arrY.get(i).x-midPoint.x)<minDistance)
                arrCase3.add(arrY.get(i));
        }
        return Math.min(minDistance,calculateCase3(arrCase3,arrCase3.size(),minDistance));
    }
    public static double findClosestDistance(int[] x,int[] y,int count){
        ArrayList<Point> arrX=new ArrayList<>();
        ArrayList<Point> arrY=new ArrayList<>();
        for (int i=0;i<x.length;i++){
            Point p=new Point(x[i],y[i]);
            arrX.add(p);
            arrY.add(p);
        }
        Collections.sort(arrX,(a,b)->a.x-b.x);
        Collections.sort(arrY,(a,b)->a.y-b.y);

        return closestRecursive(arrX,arrY,arrX.size());
    }
    public static double distance(Point p1,Point p2){
        return Math.sqrt((p1.x- p2.x)*(p1.x- p2.x)+(p1.y- p2.y)*(p1.y- p2.y));
    }
    public static void main(String[] args) {
        int[] x={2,12,40,5,12,3};
        int[] y={3,30,50,1,10,4};
        System.out.println(findClosestDistance(x,y,x.length));
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
