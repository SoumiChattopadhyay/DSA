public class Prog5_PalindromeLL {
    public static class Node{
        char data;
        Node next;
        public Node(char data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static boolean checkPalindrome(){
        //find mid node
        Node slow=head,fast=head.next;
        Node mid;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        mid=slow;
        //split
        Node rightHead=mid.next;
        mid.next=null;
        //reverse right half. Why not left half?
        //suppose odd length list [1,2,3,2,1] midnode=3, u are reversing left half then 1,2,3 becomes 3,2,1 then when u compare left half(3,2,1) and right half(2,1) then immediately 3!=2 loop ends.
// Then u say let's not include the midnode then but midnode needs to be included for even length lists. Ex:[1,2,2,1] 
// So reverse right half then 2,1 becomes 1,2 and when u compare it with left half(1,2,3) then 1,2=1,2 then loop ends as right half ends.
        Node curr=rightHead, prev=null,next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node ptr=head;
        while(ptr!=null && prev!=null ){
            if(ptr.data!=prev.data){
                return false;
            }
            ptr=ptr.next;
            prev=prev.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node one = new Node('a');
        Node two = new Node('b');
        Node three = new Node('c');
        Node four = new Node('d');
        Node five = new Node('c');
        Node six = new Node('b');
        Node seven = new Node('a');
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        head=one;
        tail=six;
        System.out.println("Palindrome :" + checkPalindrome());
    } 
}
