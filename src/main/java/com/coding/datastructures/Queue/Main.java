package com.coding.datastructures.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        //QueueUsingLL q = new QueueUsingLL();
        //QueueUsingArray q = new QueueUsingArray(4);
        //QueueUsingCircularArray q = new QueueUsingCircularArray(4);
        QueueUsing2stack q = new QueueUsing2stack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(50);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    }
}
