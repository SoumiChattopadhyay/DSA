public class Prog1_mergeSortll{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public Node head;
    public Node tail;
    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        // step-1 : find mid node: for even length the 1st mid is taken by slow fast technique like in arrays where using the formula (si+ei)/2 the 1st mid is taken 
        Node mid = findMidNode(head);
        //step-2 : split ll based on midnode
        Node rightHead = mid.next;
        mid.next=null;
        Node newLeftHead = mergeSort(head);//can't use index so need to keep track of heads of subnodes. midnode is head of right subnodes and head is head of left subnodes
        Node newRightHead = mergeSort(rightHead);
        //step-3 : sort and merge them
        return merge(newLeftHead,newRightHead);//head,rightHead
    }
    //wrong
    //  public void mergeSort2(Node head){
    //     if(head==null || head.next==null){
    //         return;
    //     }
    //     // step-1 : find mid node
    //     Node mid = findMidNode(head);
    //     //step-2 : split ll based on midnode
    //     Node rightHead = mid.next;
    //     mid.next=null;
    //     mergeSort(head);//can't use index so need to keep track of heads of subnodes. midnode is head of right subnodes and head is head of left subnodes
    //     mergeSort(rightHead);
    //     //step-3 : sort and merge them
    //     merge(head,rightHead);
    // }
    public Node merge(Node leftHead, Node rightHead){
        Node temp = new Node(-1);
        Node ptr=temp;
        Node i=leftHead, j=rightHead;
        while(i!=null && j!=null){
            if(i.data<j.data){
                ptr.next=i;
                i=i.next;
            }else{
                ptr.next=j;
                j=j.next;
            }
            ptr=ptr.next;
        }
        while(i!=null){
            ptr.next=i;
            i=i.next;
            ptr=ptr.next;
        }
        while(j!=null){
            ptr.next=j;
            j=j.next;
            ptr=ptr.next;
        }
        return temp.next;
    }
    public Node findMidNode(Node head){//This function also needs just the starting noe
        //slow fast technq.
        Node slow=head,fast=head.next;//for even lengths we get two midnodes theoretically and we want the first midnode, so we write fast=fast.next
        while(fast!=null && fast.next!=null){//do not change the order of conditions to avoid NullPointerException
            slow=slow.next;
            fast=fast.next.next;
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
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+"->");
            ptr=ptr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Prog1_mergeSortll ll = new Prog1_mergeSortll();
        ll.addFirst(50);
        ll.addFirst(20);
        ll.addFirst(10);
        // ll.addFirst(40);
        ll.addFirst(60);
        ll.addFirst(30);
        ll.printList();
        ll.head=ll.mergeSort(ll.head);//this function needs the starting node
        ll.printList();
        // ll.mergeSort2(ll.head);
        // ll.printList();
    }
}
