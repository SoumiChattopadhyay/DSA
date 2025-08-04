public class Prog7_DetectingCycle {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public boolean isCyclic(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public void printList(){
        Node ptr=head;
        while(ptr!=null){
            System.out.print(ptr.data+"->");
            ptr=ptr.next;
        }
        System.out.print("null");
    }
    public static Node head;
    public static Node tail;
    public static void main(String[] args) {
        Prog7_DetectingCycle ll = new Prog7_DetectingCycle();
        head=new Node(1);
        head.next=new Node(2); 
        head.next.next=new Node(3);
        head.next.next.next=head.next;
        // head.next.next.next=null;
        System.out.println(ll.isCyclic());
    }
}
