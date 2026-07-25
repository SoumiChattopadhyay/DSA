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
    // Time Complexity: O(2*N + N*LogN), we traverse the linked list, store its elements in an array,
    // sort it, and then copy the sorted values back into the original list.
    // Space Complexity: O(N) , additional space required to store all the elements of linked list 
    // in an array.
    /* Algorithm: 
    To sort a given linked list, we can simply create an array of all the elements of the linked list. 
    Now, we can sort this array using any sorting technique and reassign the values of the sorted 
    array to our linked list. This modified linked list will have all the elements in sorted order.   */
    public Node sortLL_1(Node head){
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
    // Optimal
    // Time Complexity: O(N*LogN), we recursively divide the linked list into two halves and then 
    // merge two sorted halves.
    // Space Complexity: O(1),constant additional space is required to sort the entire linked list.
    /*
    Algorithm:
        Instead of using an external array to store node values, we can try to implement similar sorting techniques for linked lists as well. In order to sort the linked list, we can try to implement a modified version of Merge Sort Algorithm. This algorithm would divide the linked list into halves recursively until single nodes remain. These sorted halves of the linked list are merged back together in a sorted order.
    Steps:
        If the linked list is empty or has only one node, it is already sorted, thus we can return the head directly.
        Use the slow and fast pointer technique to find the middle of the linked list, where slow moves one step and fast moves two steps at a time.
        Split the linked list into two halves at the midpoint by pointing middle to null, where the left half starts from the head and the right half starts from the node after the middle.
        Recursively apply merge sort on both halves of the linked list until each part is broken down into single nodes or empty lists.
        Merge the two sorted halves using a helper function that compares node values from both halves, attaches the smaller one to the result list, and continues until all nodes from both halves are merged.
        Return the head of the merged and fully sorted linked list, which will represent the final sorted list.
    */
    // Function to perform merge sort
    public Node sortLL_2(Node head){
        // Base Case
        if(head==null || head.next==null){//first check used if accidentally empty list has been passed, while 2nd check used to ensure whenever single node has been reached, return happens to prevent infinite recursion calls.
            return head;
        }

        // Find middle node of ll
        Node mid = findMidNode(head);
        
        // Split ll into 2 halves
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;
        
        // Recursively sort both halves
        leftHead = sortLL_2(leftHead);
        rightHead = sortLL_2(rightHead);

        // Merge halves
        return merge2LinkedLists(leftHead, rightHead);
    }
    // Function to find middle of linked list
    public Node findMidNode(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){// If list empty or single node
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    // Function to merge 2 linked lists
    public Node merge2LinkedLists(Node leftHead, Node rightHead){
        Node head = new Node(-1,null);
        Node ptr = head;
        while(leftHead!=null && rightHead!=null){
            if(leftHead.data<rightHead.data){
                ptr.next = leftHead;
                leftHead=leftHead.next;
            }else{
                ptr.next = rightHead;
                rightHead=rightHead.next;
            }
            ptr=ptr.next;
        }
        // Attach remaining node (if any)
        if(leftHead!=null){
            ptr.next=leftHead;
        }else{
            ptr.next=rightHead;
        }
        return head.next;//Return head of merged list
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
        // obj.printList(obj.sortLL_1(head));
        obj.printList(obj.sortLL_2(head));
    }
}
