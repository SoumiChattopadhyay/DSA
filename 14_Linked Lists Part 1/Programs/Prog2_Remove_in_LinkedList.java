public class Prog2_Remove_in_LinkedList{
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
    // https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
    public Node removeMiddle(Node head) {
        if(head.next==null){//if linked list has only single el.
            head=null;
            return null;
        }
        Node ptr = head;
        int len = findLen(ptr);
        int midIdx = (len/2);
        for(int i=0;i<midIdx-1;i++){//move ptr to midIdx-1
            ptr=ptr.next;
        }
        Node delNode = ptr.next;
        ptr.next = ptr.next.next;
        delNode.next=null;
        return head;
    }
    public int findLen(Node ptr){
        int len=0;
        while(ptr!=null){
            len++;
            ptr=ptr.next;
        }
        return len;
    }
    // Approach 2(Better)
    public Node removeMiddle2(Node head) {
        if(head==null || head.next==null){//if linked list has no el or single el.
            head=null;
            return null;
        }
        
        Node slow=head, fast=head, prev=head;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        // Now slow points to middle el and prev points to prev el of middle el
        prev.next = slow.next;
        slow.next=null;
        return head;
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
    // https://leetcode.com/problems/delete-node-in-a-linked-list/description/
    // Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
    // The value of the given node should not exist in the linked list.
    // The number of nodes in the linked list should decrease by one.
    // All the values before node should be in the same order.
    // All the values after node should be in the same order.
    public void removeNode(Node node){
        node.data = node.next.data;
        node.next = node.next.next;
        // Turn 4-->5-->1-->9-->null into 4-->1-->9-->null without actually deleting any node from memory
        // So after step 1 : 
        // 4-->1-->1-->9
        // After step 2:
        // 4-->1-->9-->null 
        //         |
        //         1
        // So the linked list is 4-->1-->9-->null
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
        Prog2_Remove_in_LinkedList ll = new Prog2_Remove_in_LinkedList();
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
        System.out.println("Deleted value = "+delVal+",");
        ll.printList();
        System.out.println("Size of ll = "+ll.size);
        
        Node ptr=head.next;
        ll.removeNode(ptr);
        ll.printList();
    }
}
