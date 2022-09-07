package com.coding.Algorithms;

import java.util.ArrayDeque;
import java.util.Stack;

public class PostfixtoPrefix {
    static String postToPre(String post_exp){
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < post_exp.length(); i++) {
            char cur = post_exp.charAt(i);
            if(Character.isLetterOrDigit(cur)){
                stack.push(cur+"");
            }
            else{
                String op2 = stack.pop();
                String op1 = stack.pop();
                String temp= cur+op1+op2;
                stack.push(temp);
            }
        }
        // concatenate all strings in stack and return the
        // answer
        String ans = "";
        for (String i : stack)
            ans += i;
        return ans;
    }

    public static void main(String[] args) {
        String post_exp = "ABC/-AK/L-*";
        System.out.println(postToPre(post_exp));
       // System.out.println(postToPre2(post_exp));
    }

}
