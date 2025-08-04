public class Prog4_ReverseLL {
    public static class Node{
        int data;//property of class Node(member variables)
        Node next;//property of class Node
        public Node(int data){//constructor for creating objects of class Node with above properties
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;//directly accessible
    public static Node tail;//directly accessible
    public int size;//since it is a static variable Java automatically initializes it to 0
    //Incrementing the size every time a node is created is a constant operation so the overall time complexity for finding the size of the linked list is O(1)
    //Methods
    public static void reverseLL(){
        Node prev=null;//curr node is the head. It will become the tail. It's prev is taken as null  
        Node curr=tail=head;//assigns head's value to tail and tail's value to curr. Assignment in Java is from right to left
        Node next;//local to this function

        while(curr!=null){
            next=curr.next;//defining what next is
            curr.next=prev;//forming new link
            prev=curr;//moving ahead
            curr=next;//moving ahead
        }
        head=prev;//coz curr is null
    }
    public void addFirst(int data){//TC = O(1)
        //create new node
        Node newNode = new Node(data);
        size++;
        //If linked-list is empty
        if(head==null){
            head=tail=newNode;
            return;
        }
        //If linked-list has other nodes
        newNode.next=head;
        head=newNode;
    }
    public void printList(){//TC:O(n) since this function goes to every single node of linked list
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }
        Node ptr=head;//We cant use head directly because we will lose track of the first node then that was the motive of head track the first node
        while(ptr!=null){//TC=O(n)
            System.out.print(ptr.data+"->");
            ptr=ptr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Prog4_ReverseLL ll = new Prog4_ReverseLL();
        // In static functions we can only call other static functions directly, but since we'll use the ll object to call the functions so we can call non-static functions also.
        ll.addFirst(50);
        ll.addFirst(40);
        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);
        ll.printList();
        reverseLL();
        ll.printList();
    }
}