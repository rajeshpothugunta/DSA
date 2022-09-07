package com.coding.datastructures.Stacks;

public class Main {
    public static void main(String[] args) throws Exception {
        TwoStacksUsingArray obj = new TwoStacksUsingArray(5);

        obj.push1(10);
        obj.push1(20);
        obj.push1(30);

        obj.push2(40);
        obj.push2(50);

        System.out.println(obj.pop1());
        System.out.println(obj.pop1());

        System.out.println(obj.pop2());
        System.out.println(obj.pop2());

        System.out.println("*****************************MinStack*************************************");
        MinStackwithTwoStacks minStackwithTwoStacks = new MinStackwithTwoStacks();
        minStackwithTwoStacks.push(10);
        minStackwithTwoStacks.push(2);
        System.out.println("min till now:"+ minStackwithTwoStacks.min());
        minStackwithTwoStacks.push(1);
        System.out.println("min till now:"+ minStackwithTwoStacks.min());
        minStackwithTwoStacks.pop();
        minStackwithTwoStacks.push(5);
        System.out.println("min till now:"+ minStackwithTwoStacks.min());
        minStackwithTwoStacks.pop();
        System.out.println("min till now:"+ minStackwithTwoStacks.min());
        minStackwithTwoStacks.push(2);
        System.out.println("min till now:"+ minStackwithTwoStacks.min());
        minStackwithTwoStacks.push(10);
        System.out.println("min till now:"+ minStackwithTwoStacks.min());
        minStackwithTwoStacks.push(1);
        System.out.println("min till now:"+ minStackwithTwoStacks.min());
        System.out.println("*****************************MinStack O(1) *************************************");
        MinStackwithNoextraSpace minStackwithNoextraSpace = new MinStackwithNoextraSpace();
        minStackwithNoextraSpace.push(5);
        minStackwithNoextraSpace.push(2);
        System.out.println("min" + minStackwithNoextraSpace.min());
        System.out.println("popped" + minStackwithNoextraSpace.pop());
        System.out.println("min" + minStackwithNoextraSpace.min());
        minStackwithNoextraSpace.push(9);
        minStackwithNoextraSpace.push(1);
        minStackwithNoextraSpace.push(6);
        System.out.println("min" + minStackwithNoextraSpace.min());
        System.out.println("popped" + minStackwithNoextraSpace.pop());
        System.out.println("min" + minStackwithNoextraSpace.min());
        System.out.println("popped" + minStackwithNoextraSpace.pop());
        System.out.println("min" + minStackwithNoextraSpace.min());
        System.out.println("popped" + minStackwithNoextraSpace.pop());
    }
}
