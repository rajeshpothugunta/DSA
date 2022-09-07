package com.coding.datastructures.Stacks;

import java.util.ArrayDeque;

public class MinStackwithNoextraSpace {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    private int min = 0;
    //push operation
    void push(int t){
        if(stack.isEmpty()){
            stack.push(t);
            min=t;
            return;
        }
        if(t>=min){
            stack.push(t);
        }
        else {
            stack.push(2*t-min);
            min=t;
        }
    }
    //pop operation
    int pop() throws Exception {
        if(stack.isEmpty()) throw new Exception("stack is empty");
        int t=stack.pop();
        if (t>=min)
            return t;
        else {
            int ans=min;
            min=2*min-t;
            return ans;
        }
    }
    //Min operarion
    int min() throws Exception {
        if(stack.isEmpty()) throw new Exception("Stack is empty");
        return min;
    }
    //Peek operation
    int peek() throws Exception {
        if(stack.isEmpty()) throw new Exception("Stack is empty");
        int t = stack.peek();
        if(t >= min) {
            return t;
        } else {
            return min;
        }
    }
}
