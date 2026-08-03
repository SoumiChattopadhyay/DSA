/*
Examples
Input: 4->5->6

Output: 4->5->7
Explanation: 456 + 1 = 457
Input: 9->9->9

Output: 1->0->0->0
Explanation: 999 + 1 = 1000
*/
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
public class Prog24_Add_1_to_a_number_represented_by_LL {
    /*
    Recursive Approach
    Algorithm:
    Since the number is stored in most-significant-digit first order, it’s difficult to perform 
    addition directly because we need to handle carry from the last digit (least significant digit).
    Using recursion, we can traverse to the last node first, perform the addition with carry, and 
    propagate the carry backwards. Hence the steps:
        Using a recursive function, traverse to the end of the linked list
        Add 1 to the last node and propagate any resulting carry backwards through the recursive calls.
        At each step, add the carry to the current node's value and update the carry.
        Once recursion completes, if a carry still remains, create a new node at the beginning of the list with value 1.
        Return the updated head of the list.
    */
    // Time Complexity: O(n), One pass for addition.
    // Space Complexity: O(n), Auxiliary stack space.
    // Function to add one to the number represented by the linked list
    public Node addOne_1(Node head){
        // Perform recursive addition
        int carry = addOne_1_util(head);
        
        // If carry remains after processing the head, create a new head node
        if(carry!=0){
            Node newNode = new Node(carry);
            newNode.next=head;
            head=newNode;
        }
        return head;
    }

    // Recursive function to add one from least significant digit (rightmost node)
    public int addOne_1_util(Node ptr){
        // Base case: when reaching beyond last node, return carry = 1
        if(ptr==null){
            return 1;
        }

        int carry = addOne_1_util(ptr.next);
        int sum = ptr.data + carry;
        ptr.data = sum%10;
        carry = sum/10;
        return carry;// Return new carry
    }
    
    /*
    Iterative Approach
    Algorithm:
        Since the least significant digit is at the end of the list, we can’t process it directly using a single traversal. Therefore, to perform addition from the end, we need to reverse the list.
        Reverse the list and start from the head and add 1. Carry it forward as needed.
        If a carry remains after the last node, add a new node with value 1.
        Reverse the list again to restore the original order and return the head of the modified list.
    */
    // Time Complexity: O(n), Two reversals + one pass for addition.
    // Space Complexity: O(1), Iterative, no extra stack used.
    public Node addOne_2(Node head){ // Function to add one to the number represented by the linked list
        head=reverseLL(head);// Reverse the list to make least significant digit accessible
        Node ptr=head;
        int carry=1;
        while(ptr!=null || carry>0){
            int sum = ptr.data+carry;
            ptr.data = sum%10;
            carry = sum/10;
            
            // If there's no next node and we still have a carry, append a new node
            if(ptr.next==null && carry>0){
                ptr.next=new Node(carry);
                carry=0;
            }

            ptr=ptr.next;
        }
        head=reverseLL(head); // Reverse the list back to restore original order
        return head;
    }
    public Node reverseLL(Node head){// function to reverse the linked list
        if(head==null || head.next==null){
            return head;
        }
        Node prev=null;
        Node curr=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
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
        // Node head = new Node(4);
        // head.next = new Node(5);
        // head.next.next = new Node(6);

        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        
        Prog24_Add_1_to_a_number_represented_by_LL obj = new Prog24_Add_1_to_a_number_represented_by_LL();
        obj.printList(head);
        obj.printList(obj.addOne_1(head));
        // obj.printList(obj.addOne_2(head));
    }
}
