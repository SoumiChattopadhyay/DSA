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

public class Prog22_Sort_0s_1s_2s {
    /*
    Algorithm: 
    Instead of sorting by swapping data values, we need to rearrange the actual links. The key 
    insight is to maintain three separate chains for 0's, 1's, & 2's, then connect them at the end.
    We traverse the original list once, and for each node:
    If value is 0, add it to the "zero's" chain
    If value is 1, add it to the "one's" chain
    If value is 2, add it to the "two's" chain
    Finally, we connect zero's chain to one's chain and then one's chain to two's chain
    Handle edge cases where any chain might be empty
    */
    // Time Complexity: O(n), We traverse the entire list once.
    // Space Complexity: O(1), Only dummy nodes and pointers are used (constant space).   
    public Node sortZeroOneTwo(Node head){
        Node zeroHead = new Node(-1,null);
        Node oneHead = new Node(-1,null);
        Node twoHead = new Node(-1,null);
        
        Node ptr=head;
        Node zeroTail=zeroHead, oneTail=oneHead, twoTail=twoHead;

        while(ptr!=null){
            if(ptr.data==0){
                zeroTail.next=ptr;
                zeroTail=zeroTail.next;
            }
            else if(ptr.data==1){
                oneTail.next=ptr;
                oneTail=oneTail.next;
            }
            else{
                twoTail.next=ptr;
                twoTail=twoTail.next;
            }
            ptr=ptr.next;
        }
        zeroTail.next = (oneHead.next!=null) ? oneHead.next : twoHead.next;//if there are no 1s in the ll, then zerTail must be attached to twoHead
        oneTail.next=twoHead.next;
        twoTail.next=null;//delete original links. Suppose the ll was [1-->0-->2-->0-->2-->1-->null] then after while loop, the ll would look like [0-->0-->1-->1-->2-->2] But The last 2 doesnt point to null, it still points to its previous link i.e. 1 which further points to something else so infinite printing will happen
        
        return zeroHead.next;
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
        // Node head = new Node(1);
        // head.next = new Node(0);
        // head.next.next = new Node(2);
        // head.next.next.next = new Node(0);
        // head.next.next.next.next = new Node(2);
        // head.next.next.next.next.next = new Node(1);
        // Prog22_Sort_0s_1s_2s obj = new Prog22_Sort_0s_1s_2s();
        // obj.printList(head);
        // head=obj.sortZeroOneTwo(head);
        // obj.printList(head);

        // Node head = new Node(2);
        // head.next = new Node(0);
        // head.next.next = new Node(2);
        // head.next.next.next = new Node(0);
        // head.next.next.next.next = new Node(2);
        // Prog22_Sort_0s_1s_2s obj = new Prog22_Sort_0s_1s_2s();
        // obj.printList(head);
        // head=obj.sortZeroOneTwo(head);
        // obj.printList(head);

        // Node head = new Node(2);
        // head.next = new Node(1);
        // head.next.next = new Node(2);
        // head.next.next.next = new Node(1);
        // head.next.next.next.next = new Node(2);
        // Prog22_Sort_0s_1s_2s obj = new Prog22_Sort_0s_1s_2s();
        // obj.printList(head);
        // head=obj.sortZeroOneTwo(head);
        // obj.printList(head);

        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);
        Prog22_Sort_0s_1s_2s obj = new Prog22_Sort_0s_1s_2s();
        obj.printList(head);
        head=obj.sortZeroOneTwo(head);
        obj.printList(head);
    }
}
