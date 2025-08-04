public class Prog18_reverse_Alternate_k_Group {
    public static class ListNode{
        int data;
        ListNode next;
        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static ListNode head;
    public static ListNode tail;
    public static void main(String[] args) {
        head=new ListNode(1);
        head.next=new ListNode(2); 
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head=reverse_Alternate_k_Group(head,2);
        printList();
    }
    // TC=O(n)(only reversing), SC=O(1) (no extra space taken)
    public static ListNode reverse_Alternate_k_Group(ListNode head,int k){//reverse only the nodes from idx left and to idx right
        if(k<=1 || head==null){//do nothing
            return head;
        }
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;

        while(curr!=null){
        // code similar to Prog16_reverse part of ll, but the first for loop is not needed as we are not skipping any node from start 
        ListNode last=prev;
        ListNode newEnd=curr;

        // reverse the part till k
        for(int i=1;i<=k && curr!=null;i++){//following 1-indexing that's why i=1, otherwise u can make i=0
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // join
        if(last!=null){//if last is null i.e. no nodes before,the make prev as the head, otherwise join prev to last
            last.next=prev;
        }else{
            head=prev;
        }
        newEnd.next=curr;
        //skip k nodes
        for(int i=1;i<=k && curr!=null;i++){
            prev=curr;
            curr=curr.next;
        } 
    }
        return head;
    }
    public static void printList(){
        ListNode ptr=head;
        while(ptr!=null){
            System.out.print(ptr.data+"->");
            ptr=ptr.next;
        }
        System.out.print("null");
    }
}


