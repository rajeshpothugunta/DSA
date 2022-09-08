package com.coding.datastructures.heaps;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("******************MinHEAP***********************************");
        MinHeap minHeap = new MinHeap(4);
        minHeap.insert(2);
        minHeap.insert(10);

        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
        System.out.println("size is: "+minHeap.size());

        minHeap.insert(15);
        minHeap.insert(1);

        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
        System.out.println("size is: "+minHeap.size());

        System.out.println("******************MaxHEAP***********************************");
        MaxHeap maxHeap=new MaxHeap(4);
        maxHeap.insert(2);
        maxHeap.insert(10);

        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();

        maxHeap.insert(15);
        maxHeap.insert(1);

        maxHeap.printHeap();
        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();
        //Heap sort
        System.out.println("******************HeapSort***********************************");
        int a[] = {0, 2, 9, 4, 7, 1, 6, 8};
        MinHeap minHeap2 = new MinHeap(a);
        minHeap2.printHeap();

        minHeap2.heapSort();
    }
}
