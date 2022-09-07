package com.coding.datastructures.LinkedList;

public class DoubleLinkedList {
    public static void main(String[] args) {
        LinkNode n1 = new LinkNode(10);
        LinkNode n2 = new LinkNode(20);
        LinkNode n3 = new LinkNode(30);
        LinkNode n4 = new LinkNode(40);
        LinkNode n5 = new LinkNode(25);

        LinkNode head = n1;
        //n1.previous=null;
        n1.next = n2;
        n2.previous=n1;
        n2.next = n3;
        n3.previous=n2;
        n3.next = n4;
        n4.previous=n3;
        n4.next = n5;

        PrintLL(head);
        //transverseForward(n2);
        //transverseBackward(n4);
        //searchNode(30,head);
        //insertFront(5,head);
        //insertAtEnd(50,head);
        deleteNodeAtGivenPos(3,head);
    }
    public static void transverseForward(LinkNode start) {
        LinkNode current = start;

        //Checks whether the list is empty
        if (start == null) {
            System.out.println("Node to start from is NULL");
            return;
        }

        while (current != null) {
            System.out.println("Node : " + current.value);
            current = current.next;
        }
    }

    static void PrintLL(LinkNode head) {
        LinkNode cur = head;
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
        System.out.println("end");
    }
    public static void transverseBackward(LinkNode start) {
        LinkNode current = start;

        //Checks whether the list is empty
        if (start == null) {
            System.out.println("Node to start from is NULL");
            return;
        }

        while (current != null) {
            System.out.println("Node : " + current.value);
            current = current.previous;
        }
    }
    public static void searchNode(int value, LinkNode head) {
        int i = 1;
        //Node current will point to head
        LinkNode current = head;

        //Checks whether the list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Traversing the List.
        while (current != null) {
            //Compare value to be searched with each node in the list
            if (current.value == value) {
                System.out.println("Node is present in the list at the position : " + i);
                return;
            }
            current = current.next;
            i++;
        }
        System.out.println("Node is not present in the list");
    }
    // Adding a node at the front of the list
    public static void insertFront(int newValue, LinkNode head) {

        // Create New Node and put data in it.
        LinkNode newNode = new LinkNode(newValue);

        // Update next of the new node as head and previous as NULL.
        newNode.next = head; // i.e. X.next = A. Head points to A yet.

        // Since X = first Node, so its prev should point to NULL.
        newNode.previous = null;

        // Change prev of head node to new node
        // Head points to A, so change A Previous to be X.
        if (head != null)
            head.previous = newNode;

        // Since X and A pointers are altered, we can not point Head to X which is the new start of the DLL.
        head = newNode;
        PrintLL(head);
    }
    // Given a node as previousNode, insert a new node after it.
    public void InsertAfter(LinkNode previousNode, int newValue) {

        // Check if the given prev_node is NULL
        if (previousNode == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        // Create New Node and put data in it.
        LinkNode newNode = new LinkNode(newValue);

        // Make next of new node as next of previousNode
        // X --> C.next i.e. X --> D
        newNode.next = previousNode.next;

        // Make the next of previousNode as newNode
        // C --> X
        previousNode.next = newNode;

        // Make previousNode as previous of newNode
        // C <-- X
        newNode.previous = previousNode;

        // Change the previous of D to point to X.
        // newNode.next = D, D.previous = X OR set X <-- D
        if (newNode.next != null)
            newNode.next.previous = newNode;
    }
    // Add a node at the end of the list
    static void insertAtEnd(int newValue, LinkNode head) {
        // Create New Node and put data in it.
        LinkNode newNode = new LinkNode(newValue);

        // Since this Node = Last Node, its Next needs to be Null.
        newNode.next = null;

        // If the Linked List is empty, then make this new Node as head
        if (head == null) {
            newNode.previous = null;
            head = newNode;
            return;
        }

        LinkNode last = head;
        // Else traverse till the last node
        while (last.next != null)
            last = last.next;

        // Change the next of last node
        // C --> X
        last.next = newNode;

        // Make last node as previous of new node
        // C <-- X
        newNode.previous = last;
        PrintLL(head);
    }
    static void deleteNode(LinkNode nodeToDelete, LinkNode head) {

        // If the DLL is Empty or the NodeToDelete is Null, then there is nothing to do.
        if (head == null || nodeToDelete == null) {
            return;
        }

        // If node to be deleted is head node
        // Head now points to the next of nodeToDelete meaning nodeToDelete is not a part of DLL anymore.
        if (head == nodeToDelete) {
            head = nodeToDelete.next;
        }

        // If nodeToDelete is NOT the last node:
        // A --> B --> C, Delete B, then A <-- C
        if (nodeToDelete.next != null) {
            nodeToDelete.next.previous = nodeToDelete.previous;
        }

        // If nodeToDelete is NOT the first node
        // A --> B --> C, Delete B, then A --> C
        if (nodeToDelete.previous != null) {
            nodeToDelete.previous.next = nodeToDelete.next;
        }

    }
    static void deleteNodeAtGivenPos(int position,LinkNode head) {
        // If the list in NULL or invalid position is given.
        if (head == null || position <= 0)
            return;

        LinkNode current = head;

        // traverse up to the node at position 'position' from the beginning.
        for (int i = 1; current != null && i < position; i++) {
            current = current.next;
        }

        // if 'position' is greater than the number of nodes in the doubly linked list
        if (current == null)
            return;

        deleteNode(current,head);
        PrintLL(head);
    }



}
class LinkNode {
    LinkNode previous;  // Pointer to the Previous Element
    int value;      // Value stored in this element.
    LinkNode next;      // Pointer to the Next Element

    public LinkNode(int value) {
        this.value = value;
    }
}
