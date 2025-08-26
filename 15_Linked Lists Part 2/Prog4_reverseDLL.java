public class Prog4_reverseDLL {
    public static class Node{
        Node prev;
        int data;
        Node next;
        public Node(int data){
            this.prev=null;
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public int size;

    public void reverseDLL(){
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void printList(){
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+"<->");
            ptr=ptr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Prog4_reverseDLL dll = new Prog4_reverseDLL();
        dll.addFirst(30);
        // dll.addFirst(20);
        dll.addFirst(10);
        dll.addFirst(0);
        dll.printList();
        dll.reverseDLL();
        dll.printList();
    }
}
