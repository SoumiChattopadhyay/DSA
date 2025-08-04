public class Prog19_rotate_a_list {
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
        head=rotateRight(head,2);
        printList();
    }
    // k is no. of times u need to rotate the list
    // TC=O(n)(only reversing), SC=O(1) (no extra space taken)
    public static ListNode rotateRight(ListNode head,int k){//reverse only the nodes from idx left and to idx right
        if(k<=0 || head==null ||head.next==null){//do nothing
            return head;
        }
        ListNode lastNode=head;
        int length=1;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
            length++;
        }
        int rotations=k%length;
        int skip=length-rotations;
        ListNode newLast=head;
        for(int i=1;i<skip;i++){
            newLast=newLast.next;
        }
        lastNode.next=head;
        head=newLast.next;
        newLast.next=null;
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
