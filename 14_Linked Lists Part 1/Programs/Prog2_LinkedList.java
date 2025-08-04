public class Prog2_LinkedList{
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
    public int removeFirst(){//TC=O(1)
        if(size==0){//or if(head==null)
            System.out.println("Data underflow. LL is empty.");
            return Integer.MIN_VALUE;
        }else if(size==1){//tail will otherwise still be pointing to the deleted node so we have to set it to null
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){//TC=O(n)
        if(size==0){
            System.out.println("Data underflow. LL is empty.");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            return val;
        }
        Node ptr = head;
        for(int i=0;i<size-2;i++){//we are depending on incrementation of i for the ptr traversal. You have 4 nodes indexed 0,1,2,3. Which node u wanna delete? Node at idx3. Whoch node u wanna stop at? Node at idx 2. Suppose i=0, how many times u must increase i to get to 2? 2 times to reach idx 2. Actually the problem is when i=0, at that iteration instead of just staying at idx 0 pointer is moving to idx1. so that's why u wanna run from 0 to <=size-2 just do it 0 to <size-2 or <=size-3
            ptr=ptr.next;
        }
        int val = ptr.next.data;
        ptr.next=null;
        tail=ptr;
        size--;
        return val;
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
        Prog2_LinkedList ll = new Prog2_LinkedList();
        // In static functions we can only call other static functions directly, but since we'll use the ll object to call the functions so we can call non-static functions also.
        ll.addFirst(50);
        ll.addFirst(40);
        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);
        ll.printList();
        int delVal = ll.removeFirst();
        System.out.print("Deleted value = "+delVal+", ");
        ll.printList();
        // System.out.println(tail+delNode);//incorrect
        System.out.println(tail);//correct
        System.out.println(tail.next);//correct
        delVal = ll.removeFirst();
        System.out.print("Deleted value = "+delVal+",");
        ll.printList();
        System.out.println("Size of ll = "+ll.size);
    }
}
