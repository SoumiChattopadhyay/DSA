// Convert the given linked list : L(1)-->L(2)-->L(3)-->L(4)-->.....L(n-1)-->L(n)
// into zig zag fashion : L(1)-->L(n)-->L(2)-->L(n-1)-->L(3)-->L(n-2)....
public class Prog2_zigZag {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public void zigZag(){
        // step-1 : find mid node
        Node mid = findMidNode(head);
        //step-2 : split the array
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next=null;
        //step-3 : reverse the right half
        Node curr=rightHead;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        rightHead=prev;//curr is null then loop breaks so prev is the head of the right half
        //step-4 : alternate merging and making a zigzag ll
        while(leftHead!=null && rightHead!=null){
            Node nextL, nextR;//created every iteration. everytime new memory is allocated. once the loop iteration ends they go out of scope and are destroyed and then are created again, until the loop finally ends
            nextL=leftHead.next;
            leftHead.next=rightHead;
            nextR=rightHead.next;
            rightHead.next=nextL;

            leftHead=nextL;
            rightHead=nextR;
        }//when nextL becomes leftHead and nextR becomes rightHead then when we write leftHead.next=rightHead, so it automatically fulfills the gap for not writing nextL.next=nextR in the previous iteration
        
    }
    public Node findMidNode(Node head){//This function also needs just the starting noe
        //slow fast technq. But we will use fast=head.next so that for even length arrays we get the second middle as the middle node
        Node slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){//dont change the order of conditions to avoid null pointer exception
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        // If tail not given
        // Node ptr=head;
        // while(ptr.next!=null){
            // ptr=ptr.next;
        // }
        // ptr reaches the last node
        // ptr.next=newNode;
    }
    public void printList(){
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+"->");
            ptr=ptr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Prog2_zigZag ll = new Prog2_zigZag();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.addLast(60);
        ll.printList();
        ll.zigZag();
        ll.printList();
    }
}
