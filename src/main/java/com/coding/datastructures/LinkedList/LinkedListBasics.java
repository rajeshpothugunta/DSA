package com.coding.datastructures.LinkedList;

public class LinkedListBasics {
    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(25);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        PrintLL(head);
        insertLL(head, 15, 1);
        PrintLL(head);
        deleteLL(head, 1);
        PrintLL(head);
        System.out.println(findMiddleLL(head));
        bubbleSort(head);
        PrintLL(head);
        System.out.println(getKthLastElement(head,6));


    }

    static void PrintLL(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println("end");
    }

    static Node insertLL(Node head, int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        } else {
            Node cur = head;
            for (int i = 0; i < pos - 1; i++) {
                cur = cur.next;
                if (cur == null) return head;
            }
            newNode.next = cur.next;
            cur.next = newNode;
            return head;
        }

    }

    static Node deleteLL(Node head, int pos) {
        if (head == null) return null;
        if (pos == 0) {
            head.next = head;
            return head;
        }
        Node cur = head;
        for (int i = 0; i < pos - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    static int findMiddleLL(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    static void bubbleSort(Node head) {
        // Start with first node
        Node current = head;
        while (current != null) {

            Node second = current.next;
            while (second != null) {

                if (current.data > second.data) {
                    int tmp = current.data;
                    current.data = second.data;
                    second.data = tmp;
                }
                second = second.next;
            }
            current = current.next;
        }

    }
    static int getKthLastElement(Node head,int k){
        Node cur = head;
        Node behindCur=head;
        for (int i=0;i < k - 1; i++){
            cur=cur.next;
            //invalid k
            if (cur == null) {
                return -1;
            }

        }
        while (cur.next != null){
            behindCur=behindCur.next;
            cur=cur.next;
        }
        return behindCur.data;
    }
}
class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

