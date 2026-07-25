import java.util.ArrayList;
import java.util.Collections;

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

public class Prog21_Sort_a_LinkedList {
    // Brute
    /* Algorithm: 
    To sort a given linked list, we can simply create an array of all the elements of the linked list. 
    Now, we can sort this array using any sorting technique and reassign the values of the sorted 
    array to our linked list. This modified linked list will have all the elements in sorted order.   */
    public Node sortList_1(Node head){
        ArrayList<Integer> arr = new ArrayList<>();
        Node ptr=head;
        while(ptr!=null){
            arr.add(ptr.data);
            ptr=ptr.next;
        }
        Collections.sort(arr);
        int i=0;
        ptr=head;
        while(ptr!=null){
            ptr.data=arr.get(i);
            ptr=ptr.next;
            i++;
        }
        return head;
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
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(10);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(40);
        Prog21_Sort_a_LinkedList obj = new Prog21_Sort_a_LinkedList();
        obj.printList(head);
        obj.printList(obj.sortList_1(head));
    }
}
