package com.coding.JavaTutorial;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,8,6,5,4,3,1);
        //printAllNumbersInListFunctional(numbers);
        printOddNumbersInListFunctional(numbers);
        List<String> courses = List.of("Spring","Spring Boot", "API", "Microservices", "AWS", "Azure","PCF","Docker");

        courses.stream().filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
        System.out.println("Exercise-3");
        courses.stream().filter(course -> course.length()>=4)
                .forEach(System.out::println);
        System.out.println("squaresofOdd");
        printSquaresOfOddNumbersInListFunctional(numbers);
        System.out.println("print length of courses");
        courses.stream()
                .map(x->x+ ":"+ x.length())
                .forEach(System.out::println);
    }
    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        //with Lambda expression much more cleaner
        //Lambda expression is nothing but a function
        numbers.stream()
                .filter(number -> number%2!=0)//Lambda expression
                .forEach(System.out::println);//method reference
    }
    private static void printSquaresOfOddNumbersInListFunctional(List<Integer> numbers) {
        //with Lambda expression much more cleaner
        //Lambda expression is nothing but a function
        numbers.stream()
                .filter(number -> number%2!=0)//Lambda expression
                .map(x -> x*x)//mapping
                .forEach(System.out::println);//method reference
    }
}
