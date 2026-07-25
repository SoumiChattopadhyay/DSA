class Node{
    int data;
    Node next;
    // Constructor with data and next pointer
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    // Constructor with only data
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class Prog20_Intersection_of_Two_LinkedLists {
    /*
    Approach 1: Brute Force (O(mn))
    For every node in A, check every node in B.
    A1 with all nodes of B
    A2 with all nodes of B
    ...
    Too slow.
    */
    /*
    Optimal Approach 2
    Algorithm
    The difference of length method requires various steps to work on it. Using the same concept of difference of length, a different approach can be implemented. The process is as follows:-
    Take two dummy nodes for each list. Point each to the head of the lists.
    Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.
    */
    public static void main(String[] args) {
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(10);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(40);
    }
}
