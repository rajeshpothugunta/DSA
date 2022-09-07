package com.coding.Algorithms;

import java.util.ArrayDeque;

public class InfixtoPrefix {
    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println(infixToPrefix(exp));
    }
    public static int Precedence(char c){
        if(c=='+' || c=='-') return 1;
        else if(c == '*' || c == '/') return 2;
        else if(c== '^') return 3;
        else return -1;
    }

    // Function to convert an infix expression to a prefix expression.
    public static String infixToPrefix(String s) {
        // Your code here
        StringBuilder sb = new StringBuilder();
        StringBuilder input= new StringBuilder(s);
        input.reverse();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<input.length();i++){
            char cur = input.charAt(i);
            if(cur == ')'){
                stack.push(cur);
            }
            else if(cur == '('){
                while(!stack.isEmpty() && stack.peek() !=')'){
                    sb.append(stack.pop());
                }
                //remove ( as well
                stack.pop();
            }
            //cur is operand
            else if(Character.isLetterOrDigit(cur)){
                sb.append(cur);
            }
            //cur is operaror
            else{
                while(!stack.isEmpty() && Precedence(cur)<=Precedence(stack.peek())){
                    sb.append(stack.pop());
                }
                stack.push(cur);

            }
        }
        //pop the remaining elements from stack and append
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
