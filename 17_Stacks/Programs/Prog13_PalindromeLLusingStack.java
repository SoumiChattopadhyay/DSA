import java.util.Stack;
/* Time Complexity  : O(n) Space Complexity: O(n) */
public class Prog13_PalindromeLLusingStack {
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
     public static boolean checkPalindrome() {
        Stack<Character>s=new Stack<>();
        Node ptr1=head,ptr2=head;
        while(ptr1!=null){
            s.push(ptr1.data);
            ptr1=ptr1.next;
        }
        while(ptr2!=null){
            if(ptr2.data!=s.pop()){
                return false;
            }
            ptr2=ptr2.next;
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
        System.out.println("Palindrome : " + checkPalindrome());
    }
}
