package com.coding.datastructures.Queue;

public class QueueUsingLL {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
        }
    }

    private Node front, rear;

    boolean isEmpty() {
        return front == null;
    }
    //Enqueue
    void enqueue(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    //Dequeue
    int dequeue() throws Exception {
        if(isEmpty()) throw new Exception("Queue is Empty");
        int ans  = front.data;
        front = front.next;
        return ans;
    }

    //get the data about to leave
    int getFront() throws Exception {
        if(isEmpty()) throw new Exception("Queue is Empty");
        return front.data;
    }
}
