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
    // public Node getIntersectionNode_1(Node headA, Node headB){
        
    // }
    /*
    Optimal Approach 2
    Algorithm:
    The difference of length method requires various steps to work on it. Using the same concept of
    difference of length, a different approach can be implemented. The process is as follows:-
        Take two dummy nodes for each list. Point each to the head of the lists.
        Iterate over them. If anyone becomes null, point them to the head of the opposite lists and 
        continue iterating until they collide.
    */
    // Time Complexity: O(2 × max(length of list1, length of list2)), Uses the same concept of difference of lengths of two lists.
    // Space Complexity: O(1), No extra data structure is used.
    public Node getIntersectionNode_4(Node headA, Node headB){
        Node dummyA = headA;
        Node dummyB = headB;

        // Traverse both lists, when one reaches the end, redirect it to the head of the other list
        while(dummyA!=dummyB){
            dummyA = (dummyA==null)?headB:dummyA.next;
            dummyB = (dummyB==null)?headA:dummyB.next;
        }
        // loop breaks means they have collided
        return dummyA;// If they meet, the intersection node is returned, otherwise NULL is returned. You can return either dummyA or dummyB.
    }
    public void printList(Node head){
        int i=0;
        while(head!=null){
            if(i>0) System.out.print("-->"+head.data);
            else System.out.print(head.data);
            i++;
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Common part (intersection)
        Node common = new Node(2);
        common.next = new Node(4);

        // List 1: 1 -> 3 -> 1 -> 2 -> 4
        Node headA = new Node(1);
        headA.next = new Node(3);
        headA.next.next = new Node(1);
        headA.next.next.next = common;

        // List 2: 3 -> 2 -> 4
        Node headB = new Node(3);
        headB.next = common;

        Prog20_Intersection_of_Two_LinkedLists obj = new Prog20_Intersection_of_Two_LinkedLists();
        obj.printList(headA);
        obj.printList(headB);

        System.out.println(obj.getIntersectionNode_4(headA, headB).data);
    }
}
