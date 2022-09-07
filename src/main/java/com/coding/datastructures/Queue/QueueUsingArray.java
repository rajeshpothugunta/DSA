package com.coding.datastructures.Queue;

public class QueueUsingArray {
    int front,rear;
    int a[];
    int n;

    public  QueueUsingArray(int n){
        front=rear=-1;
        a=new int[n];
        this.n=n;
    }
    void enqueue(int data) throws Exception{
        if(isFull()) throw new Exception("Queue Array is Full");
        if(isEmpty()){
            front=0;
        }
        rear++;
        a[rear]=data;
    }
    int dequeue() throws Exception{
        if(isEmpty()) throw new Exception("Queue Array is empty");
        int ans = a[front]; // front is always 0
        if(front == rear) { // to check if one element only
            front = -1;
            rear = -1;
            return ans;
        }
        for(int i = 0; i<rear; i++) {
            a[i] = a[i+1];
        }
        rear--;
        return ans;
    }
    private boolean isFull(){
        return rear==n-1;
    }
    private boolean isEmpty(){
        return front==-1;
    }
}
