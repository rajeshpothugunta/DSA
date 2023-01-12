package com.coding.JavaTutorial;

import java.util.List;

//functional programming
public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,8,6,5,4,3,1);
        //printAllNumbersInListFunctional(numbers);
        printEvenNumbersInListFunctional(numbers);
    }
    public static void print(int num){
        System.out.println(num);
    }
    public static boolean isEven(int num){
        return num%2==0;
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //In functional programming we focus on what to do
        //[12,9,8,6,5,4,3,1] - stream each number
        numbers.stream().forEach(FP01Functional::print);//double colon is called method reference

        System.out.println("Method-2:");
        //Method-2
        numbers.stream().forEach(System.out::println);
    }
    //number -> number%2==0
    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {

        numbers.stream()
                .filter(FP01Functional::isEven)//Apply Filter - Allow only Even
                .forEach(System.out::println);

        //with Lambda expression much more cleaner
        //Lambda expression is nothing but a function
        System.out.println("With Lambdas");
        numbers.stream()
                .filter(number -> number%2==0)//Lambda expression
                .forEach(System.out::println);//method reference
    }
}
