package com.coding.datastructures.Queue;

import java.util.Stack;

public class QueueUsing2stack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() throws Exception{
        if(empty()) throw new Exception("Queue is Empty");
        // shift input to output
        if (stack2.empty())
            while (stack1.empty() == false) {
                stack2.push(stack1.peek());
                stack1.pop();
            }
        return stack2.pop();
    }
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

}
