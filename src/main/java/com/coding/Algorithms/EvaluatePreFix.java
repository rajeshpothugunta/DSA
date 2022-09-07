package com.coding.Algorithms;

import java.util.ArrayDeque;

public class EvaluatePreFix {
    public static void main(String[] args) {
        String exp = "-+7*45+20";
        System.out.println(evaluatePostFix(exp));
    }
    public static int evaluatePostFix(String S)
    {
        // Your code here
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=S.length()-1;i>=0;i--){
            char cur = S.charAt(i);
            //if operand
            if(Character.isLetterOrDigit(cur)){
                stack.push(cur-'0');
            }
            //if operator
            else{
                int first = stack.pop();
                int second = stack.pop();
                int eval = calculate(first, second, cur);
                stack.push(eval);
            }
        }
        return stack.pop();
    }
    public static int calculate(int a, int b, char c){
        switch(c){
            case '+':return a+b;
            case '-':return a-b;
            case '*':return a*b;
            case '/':return a/b;
        }
        return 0;
    }

}
