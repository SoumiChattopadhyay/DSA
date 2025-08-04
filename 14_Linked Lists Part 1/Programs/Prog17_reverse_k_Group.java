public class Prog17_reverse_k_Group{
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
        head=reverse_k_Group(head,2);
        printList();
    }
    // TC=O(n)(only reversing), SC=O(1) (no extra space taken)
    public static ListNode reverse_k_Group(ListNode head,int k){//reverse only the nodes from idx left and to idx right
        if(k<=1 || head==null){//do nothing
            return head;
        }
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;

        int length=getLength(head);//get length of ll
        int count=length/k;
        while(count>0){
        // code similar to Prog16_reverse part of ll, but the first for loop is not needed as we are not skipping any node from start 
        ListNode last=prev;
        ListNode newEnd=curr;

        // reverse the part till k
        for(int i=1;i<=k;i++){//following 1-indexing that's why i=1, otherwise u can make i=0
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // join
        if(last!=null){//if last node doesnt exist. ex- [3,5] l=1,r=2
            last.next=prev;
        }else{
            head=prev;
        }
        newEnd.next=curr;
        count--;
        prev=newEnd;    
    }
        return head;
    }
    public static int getLength(ListNode head){
        ListNode ptr=head;
        int len=0;
        while(ptr!=null){
            ptr=ptr.next;
            len++;
        }
        return len;
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
