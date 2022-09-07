package com.coding.datastructures.heaps;

public class MaxHeap {
    int a[];
    int capacity;
    int n;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        n=0;
        a=new int[capacity+1];
    }

    public void insert(int key) throws Exception {
        if(n == capacity)
            throw new Exception("heap is full");
        n++;
        //first insert new element
        a[n]=key;
        int i=n;
        //then make it to minheap
        while(i>1){
            int parent=i/2;
            if(a[parent]<a[i]){
                swap(a,parent,i);
                i=parent;
            }
            else
                return;
        }
    }
    public int extractMax() throws Exception{
        if(n==0) throw new Exception("Heap is Empty");

        int result=a[1];
        a[1]=a[n];
        n--;
        int i=1;
        while (i<=n){
            int left=2*i;
            int right=2*i+1;

            int greatest=i;
            if(left<=n && a[left]>a[greatest])
                greatest=left;
            if(right<=n && a[right]>a[greatest])
                greatest=right;
            if(greatest != i) {
                swap(a,greatest, i);
                i = greatest;
            } else break;
        }
        return result;
    }
    public void printHeap( ){
        for(int e:a){
            System.out.print(e+ " ");
        }
        System.out.println();
    }
    public int size(){
        return n;
    }

    private void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
