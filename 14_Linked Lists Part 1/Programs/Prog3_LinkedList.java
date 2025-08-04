public class Prog3_LinkedList{
    public static class Node{
        int data;//property of class Node(member variables)
        Node next;//property of class Node
        public Node(int data){//constructor for creating objects of class Node with above properties
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;//directly accessible
    public static Node tail;//directly accessible
    public int size;//since it is a static variable Java automatically initializes it to 0
    //Incrementing the size every time a node is created is a constant operation so the overall time complexity for finding the size of the linked list is O(1)
    //Methods
    public int recursiveSearch(int key,Node ptr, int idx){
        // if(ptr==null){//reached end of ll
        //     return -1;
        // }
        if(key==ptr.data){
            return idx;
        }
        //We have to right this before. We will get null pointer exception before
        // if(ptr==null){
        //     return -1;
        // }
        return recursiveSearch(key, ptr.next, idx+1);//2nd recSearch return position to 1st recSearch and 1st recsearch returns it to main
    }
    //Alternate approach
    public int recursiveSearch2(int key,Node head){
        if(head==null){
            return -1;//searched entire ll,el.not found
        }
        if(key==head.data){
            return 0;
        }
        int idx = recursiveSearch2(key, head.next);//2nd recSearch return position to 1st recSearch and 1st recsearch returns it to main
        //After returning to calling funct what needs to be done
        if(idx==-1){//searched entire ll,el.not found
            return -1;
        }
        return idx+1;
    }
    public int iterativeSearch(int key){
        Node ptr = head;
        int i=0;
        while(ptr!=null){
            if(ptr.data==key){
                return i;
            }
            ptr=ptr.next;
            i++;
        }
        return -1;
    }
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
    public void printList(){//TC:O(n) since this function goes to every single node of linked list
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }
        Node ptr=head;//We cant use head directly because we will lose track of the first node then that was the motive of head track the first node
        while(ptr!=null){//TC=O(n)
            System.out.print(ptr.data+"->");
            ptr=ptr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Prog3_LinkedList ll = new Prog3_LinkedList();
        // In static functions we can only call other static functions directly, but since we'll use the ll object to call the functions so we can call non-static functions also.
        ll.addFirst(50);
        ll.addFirst(40);
        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);
        ll.printList();
        System.out.println(30+" found at position "+ll.iterativeSearch(30));
        System.out.println(9+" found at position "+ll.iterativeSearch(9));
        System.out.println(20+" found at position "+ll.recursiveSearch(20,head,0));
        System.out.println(9+" found at position "+ll.recursiveSearch(9,head,0));
        System.out.println(40+" found at position "+ll.recursiveSearch2(40,head));
        System.out.println(9+" found at position "+ll.recursiveSearch2(9,head));
    }
}
