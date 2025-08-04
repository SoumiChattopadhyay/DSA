public class Prog13_removeDuplicates {//consider this as LinkedList class
    public static void main(String[] args) {
        Prog13_removeDuplicates obj = new Prog13_removeDuplicates();
        
        // to access non-static inner class in main method of outer class
        // Prog13_removeDuplicates.ListNode head = obj.new ListNode(10);
        
        // to access static inner class in main method of outer class
        head = new ListNode(10);
        head.next=new ListNode(20);
        head.next.next=new ListNode(20);
        tail=head.next.next;
        obj.printList();
        obj.deleteDuplicates();
        obj.printList();
    }
    public static class ListNode {
        // non-static instance variables of ListNode class
        int val;
        ListNode next;
        // constructors of ListNode class
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // static instance variables of LinkedList class
    static ListNode head;
    static ListNode tail;
    //non-static member methods of LinkedList class
    //TC=O(n),SC=O(1) No extra space is used (in-place modification).Only a few pointers (like ptr) are used which are just variables, not large data structures.This counts as O(1) space. Creating a new data structure like a list, array, or HashSet = Not in-place (O(n) space). In-place modification means:You change the original data structure directly without using extra space like arrays, hashmaps, or new linked lists.
    public void deleteDuplicates() {
        ListNode ptr=head;
        while(ptr!=null && ptr.next!=null){//for [] null pointer exception coz cannot read next of null
            if(ptr.val==ptr.next.val){
                ptr.next=ptr.next.next;
            }
            else{
                ptr=ptr.next;
            }
        }
        tail=ptr;
        System.out.println(tail.next==null?"null":tail.next);//tail.next is already null so no need to write tail.next=null additionally
    }
    public void printList(){//TC:O(n) since this function goes to every single node of linked list
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }
        ListNode ptr=head;//We cant use head directly because we will lose track of the first node and that is the motive of head to track the first node
        while(ptr!=null){
            System.out.print(ptr.val+"->");
            ptr=ptr.next;
        }
        System.out.println("null");
    }
}
    //if we write ptr=ptr.next outside else block that will be wrong coz the first node with a value would be left behind and next node with duplicate value will be pointed at by ptr and comparison with respect to the second node (duplicate node) would be made for the next nodes
    // so now for the same 1st ptr until the duplicates end completely comparisons are made with the first node only. comparison not made with any duplicate node. 

