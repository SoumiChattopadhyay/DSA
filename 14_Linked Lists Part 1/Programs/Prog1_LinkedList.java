public class Prog1_LinkedList{
    public static class Node{
        int data;//property of class Node(member variables)
        Node next;//property of class Node
        public Node(int data){//constructor for creating objects of class Node with above properties
            this.data=data;
            this.next=null;
        }
    }
    // Instance variables of Prog1_LinkedList class which are also static variables. Each object of Prog1_LinkedList class will get the same copy of these vars.
    public static Node head;//directly accessible
    public static Node tail;//directly accessible
    public static int size;//since it is a static variable Java automatically initializes it to 0
    
    //Incrementing the size every time a node is created is a constant operation so the overall time complexity for finding the size of the linked list is O(1)
    
    //Instance Methods of Prog1_LinkedList class
    public void addFirst(int data){//TC = O(1)
        //create new node
        Node newNode = new Node(data);
        size++;
        //If linked-list is empty
        if(head==null){
            head=tail=newNode;
            return;
        }
        //If linked-list has other nodes
        newNode.next=head;
        head=newNode;
    }
    public void addMiddle(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){//if ll is empty
            head=tail=newNode;
            return;
        }
            Node ptr=head,ptr2=head;
            int len=0;
            while(ptr!=null){//finding the length of the linked list, TC = O(n) as it involves reaching out to each node
                len++;
                ptr=ptr.next;
            }
            int middleIndex = (len/2)-1;//finding the middle index of the linked list. 
            // Insert the node at the middle index
            for(int j=0;j<middleIndex;j++){//pointer 2 is going to the node at index just before the middle index. this loop is not executed if middleindex=0 i.e. if ll has 1 node
                ptr2=ptr2.next;
            }
           newNode.next=ptr2.next;
           ptr2.next=newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    public void addSpecific(int idx, int data){
        // need a special case for idx 0 bcoz of head, we need to make sure head points at the first node. Also becoz we cant go to the previous node of the node with idx 0 coz there isnt any.
        if(idx==0){//case when list is non-empty and we want to insert at idx 0 or case when list is empty
            addFirst(data);
            return;
        }
        if(idx<0 || idx>size-1){
            System.out.println("Please give valid index.");
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node ptr=head;
        int i=0;
        while(i<idx-1){//going to the index before idx
            ptr=ptr.next;
            i++;
        }
        //Reference change
        newNode.next=ptr.next;
        ptr.next=newNode;
        // In the newly formed linked-list, you will never see the new node as the last node because then u cant use this function u have to use addLast() function. So there is no need of writing statement for tail pointer pointing to new node.
    }
    // Insert using recursion
    public void insertSpecific(int val,int idx,int i,Node ptr){
        if(i==idx-1){
            Node newNode = new Node(val);
            size++;
            newNode.next=ptr.next;
            ptr.next=newNode;
            return;
        }
        if(idx==0){//case when list is non-empty and we want to insert at idx 0 or case when list is empty
            addFirst(val);
            return;
        }
        if(idx<0 || idx>size-1){
            System.out.println("Please give valid index.");
            return;
        }
        insertSpecific(val, idx, i+1, ptr.next);
    }
    // Insert using recursion Method-2
    public void insertRec(int val,int idx){
        head=insertRecHelper(val, idx,head);//if u dont write head=, then if you wanna insert el. at idx=0 then head will not be changed and the inserted el. will still not be part of the ll. head must point to the inserted el
    }
    // TC:O(n), SC=O(n) 
    public Node insertRecHelper(int val,int idx,Node node){
        if(idx==0){//when u reach that idx where u wanna insert the node, just do 1 operation-newNode.next=node; and when u return this newNode to the previous function call then there make node.next=newNode; Like this each funct call returns the node to the previous funct call and finally the funct returns the 1st node to the insertRec funct which is stored in head
            Node newNode=new Node(val);
            newNode.next=node;
            return newNode;
        }
        node.next=insertRecHelper(val, idx-1, node.next);
        return node;
    }
    public void printList(){//TC:O(n) since this function goes to every single node of linked list
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }
        Node ptr=head;//We cant use head directly because we will lose track of the first node and that is the motive of head to track the first node
        while(ptr!=null){
            System.out.print(ptr.data+"->");
            ptr=ptr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Prog1_LinkedList ll = new Prog1_LinkedList();
        // In static functions we can only call other static functions directly, but since we'll use the ll object to call the functions so we can call non-static functions also.
        ll.printList();
        ll.addFirst(40);
        ll.printList();
        ll.addFirst(10);
        ll.printList();
        ll.addMiddle(20);
        ll.printList();
        ll.addLast(50);
        ll.printList();
        ll.addMiddle(30);
        ll.printList();
        ll.addSpecific(4,355);//following 0-based indexing
        ll.printList();
        ll.insertSpecific(455, 5, 1, head);//following 0-based indexing
        ll.printList();
        ll.addSpecific(7,355);//following 0-based indexing
        ll.insertRec(555, 0);
        ll.printList();
    }
}
