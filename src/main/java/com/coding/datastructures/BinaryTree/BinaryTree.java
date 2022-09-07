package com.coding.datastructures.BinaryTree;

import java.util.Scanner;

public class BinaryTree {
    Scanner sc;
    Node root;
    public BinaryTree() {
        sc = new Scanner(System.in);
    }
    Node createBinaryTree(){
        System.out.println("Enter Node data");
        int data = sc.nextInt();

        if(data==-1) return null;

        Node node = new Node(data);
        System.out.println("Enter "+ data + "'s left data");
        node.left = createBinaryTree();
        System.out.println("Enter "+ data + "'s right data");
        node.right = createBinaryTree();
        return node;
    }
}
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}