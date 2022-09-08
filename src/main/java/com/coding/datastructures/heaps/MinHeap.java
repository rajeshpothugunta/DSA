package com.coding.datastructures.heaps;

public class MinHeap {
    int a[];
    int capacity;
    int n;
    // ignore the a[0]
    public MinHeap(int a[]) {
        this.a = a;
        this.capacity = a.length-1;
        this.n = a.length-1;
        buildHeap();
    }
    public MinHeap(int capacity) {
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
            if(a[parent]>a[i]){
                swap(a,parent,i);
                i=parent;
            }
            else
                return;
        }
    }
    public int extractMin() throws Exception{
        if(n==0) throw new Exception("Heap is Empty");

        int result=a[1];
        a[1]=a[n];
        n--;
        int i=1;
        while (i<=n){
            int left=2*i;
            int right=2*i+1;

            int smallest=i;
            if(left<=n && a[left]<a[smallest])
                smallest=left;
            if(right<=n && a[right]<a[smallest])
                smallest=right;
            if(smallest != i) {
                swap(a,smallest, i);
                i = smallest;
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
    // O(logn)
    void heapify(int i) {
        while(i <= n) {
            int left = 2*i;
            int right = 2*i+1;

            int smallest = i;
            if(left <= n && a[left] < a[smallest]) {
                smallest = left;
            }
            if(right <= n && a[right] < a[smallest]) {
                smallest = right;
            }

            if(smallest != i) {
                swap(a,smallest, i);
                i = smallest;
            } else break;
        }
    }
    //	O(n) builds a heap from a given array
    void buildHeap() {
        for(int i = n; i>0; i--) {
            heapify(i);
        }
    }
    void heapSort() throws Exception {
        int newN = n;
        for(int i = 1; i<=newN; i++) {
            int x = extractMin();
            System.out.print(x+" ");
        }
    }

}
