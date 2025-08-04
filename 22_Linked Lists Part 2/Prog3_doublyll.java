public class Prog3_doublyll {
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
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    public void addSpecific(int idx, int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        Node prevNode=head;
        int i=1;//using 1-based indexing(u can use 0-based too)
        while(i<idx-1){//we have to reach (idx-1)th node to insert the node at idx. So run i till <idx-1 & u will reach that particular node. coz i is slower than the pointer here coz we see in the 1st iteration while i=1, pointer was in head and it moved to the 2nd node while i was still 1. So if u run i till idx-2(or <idx-1) then ptr will be at idx-1.
            prevNode=prevNode.next;
            i++;
        }
        Node temp=prevNode.next;
        prevNode.next=newNode;
        newNode.prev=prevNode;
        newNode.next=temp;

        // OR
        // newNode.next=prevNode.next;
        // prevNode.next.prev=newNode;
        // prevNode.next=newNode;
        // newNode.prev=prevNode;

    }
    public int removeFirst(){//must return the removed val
        if(head==null){
            System.out.println("Linked List is empty.");
            return Integer.MIN_VALUE;
        }
        if(size==1){//if ll had just one node which needs to be removed now
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;//no need to write head.next=null, just remove the node from the ll so that its no longer a part of it and its unreachable. Java's Garbage Collector will clean it up automatically since no part of your program points to it anymore.
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }
    public int removeLast(){
        if(head==null){
            System.out.println("Linked List is empty.");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        // cant use tail coz we need to remove the node before tail
        // we can use tail to add at last but not remove from last
        Node ptr=head;
        int i=1;//using 1-based indexing. so (size)th node is last node and (size-1)th node is second-last node
        while(i<size-1){
            ptr=ptr.next;
            i++;
        }
        int val=ptr.next.data;
        ptr.next=null;
        tail=ptr;
        size--;
        return val;
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
        Prog3_doublyll ll = new Prog3_doublyll();
        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);
        ll.addLast(50);
        ll.addLast(60);
        ll.addSpecific(4, 40);//depends on your mindset whether u are wanting 0-based or 1-based indexing. Lets assume u are wanting 1-based indexing.
        ll.printList();
        System.out.print(ll.removeFirst()+" deleted - ");
        ll.printList();
        System.out.print(ll.removeLast()+" deleted - ");
        ll.printList();
        System.out.println(ll.size);
    }
}
