public class Prog14_Segregate_Odd_and_Even_Nodes_in_a_LinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    static Node head;
    static Node tail;
    // The optimal and clean approach is to use two separate linkedlists one for even nodes and another 
    // for odd nodes. We iterate through the original linkedlist once, appending each node to the 
    // appropriate linkedlist (even or odd) based on its value. Finally, we link the last node of the 
    // even linkedlist to the head of the odd linkedlist, effectively merging the two while maintaining the 
    // required order.
    public Node segregate_Odd_Even(Node head) {
        // Edge case: If list is empty or has only one node
        if (head == null || head.next == null) return head;
        
        Node evenHead=null, oddHead=null, evenTail=null, oddTail=null;// Pointers for the heads and tails of even and odd linkedlists
        Node ptr = head;// Pointer to traverse the original linkedlist
        while(ptr!=null){//Traverse the linkedlist
            if(ptr.data%2!=0){// If the current node has even value
                if(oddHead==null){// First odd node
                    oddHead=ptr;
                    oddTail=ptr;
                }
                else{//Not first odd node
                    oddTail.next=ptr;
                    oddTail=ptr;
                }
            }
            else{// If the current node has odd value
                if(evenHead==null){//First even node
                    evenHead=ptr;
                    evenTail=ptr;
                }
                else{//Not first even node
                    evenTail.next=ptr;
                    evenTail=ptr;
                }
            }
            ptr=ptr.next;// Move to next node
        }

        // If no even nodes found, return odd list
        if (evenHead == null) return oddHead;

        // If no odd nodes found, return even list
        if (oddHead == null) return evenHead;

        // Combine odd and even lists
        oddTail.next=evenHead;

        // Set end of list to null
        evenTail.next=null;

        return oddHead;
    }
    
    public static void main(String[] args) {
        head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=head.next;
        tail=head.next;
        Prog14_Segregate_Odd_and_Even_Nodes_in_a_LinkedList obj = new Prog14_Segregate_Odd_and_Even_Nodes_in_a_LinkedList();
    }
}
