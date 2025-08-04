public class Prog6_checkPalindromeLL {
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public boolean checkPalindrome(){
        if(head==null || head.next==null){//if ll is empty or has one element
            return true;
        }
        //step 1 - find midNode
        Node midNode=findMid();
        //step 2 - reverse half ll
        Node curr=midNode;//like we did curr=head previously
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //step 3 - compare 1st half and 2nd half of ll
        Node left=head;
        Node right=prev;
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public Node findMid(){
        Node slow=head;
        Node fast=head;
        //Slow Fast Technique
        // For even length LL when fast=null, slow will be at mid node so exit loop and return slow
        // For odd length LL when fast.next=null, slow will be at mid node so exit loop and return slow
        while(fast!=null && fast.next!=null){//for even and odd ll. Dont change this order of conditions to avoid Null Pointer exception
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        return slow;
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Prog6_checkPalindromeLL ll = new Prog6_checkPalindromeLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printList();
        System.out.println(ll.checkPalindrome());
    }
}
