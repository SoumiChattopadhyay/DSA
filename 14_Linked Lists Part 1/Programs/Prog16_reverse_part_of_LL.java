public class Prog16_reverse_part_of_LL{
    // 1-->2-->3-->4-->5
    // 1-->4-->3-->2-->5
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
        head=reverseBetween(head,1,3);
        printList();
    }
    public static ListNode reverseBetween(ListNode head,int left,int right){//reverse only the nodes from idx left and to idx right
        if(left==right){//do nothing
            return head;
        }

        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;

        // skip and reach the (left)th node (but using prev and curr so that we can store 2 values the last and the newNode, normal pointer movement wont let us store 2 values)
        for(int i=1;i<left && curr!=null;i++){//following 1-indexing that's why i=1, otherwise u can make i=0
            prev=curr;
            curr=curr.next;
        }//curr now points to node at left 
        ListNode last=prev;
        ListNode newEnd=curr;

        // reverse the part till right
        for(int i=1;i<=right-left+1 && curr!=null;i++){//following 1-indexing that's why i=1, otherwise u can make i=0
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode rightHalf=curr;
        // join
        if(last!=null){//if last node doesnt exist. ex- [3,5] l=1,r=2
            last.next=prev;
        }else{
            head=prev;
        }
        newEnd.next=rightHalf;    
        
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
