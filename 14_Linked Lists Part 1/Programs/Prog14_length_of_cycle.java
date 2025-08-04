public class Prog14_length_of_cycle {
    public static class Node{
        int val;
        Node next;
        public Node(int val){//constructor cant be static coz if it becomes static it will have no access to objects, no access to 'this' then it wont be abe to initialize the obj's  instance variables with values
            this.val=val;
        }
    }
    static Node head;
    static Node tail;
    public static void main(String[] args) {
        head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=head.next;
        tail=head.next;
        Prog14_length_of_cycle obj = new Prog14_length_of_cycle();
        System.out.println("Length of cycle is: " + obj.find_Length_of_Cycle());
    }
    public int find_Length_of_Cycle(){
        // code similar to removing cycle code except no prev needed here
        // detect cycle by 1st meeting of slow-fast
        // keep fast at the meeting point
        // move slow to the head
        // where slow and fast meet for the 2nd time is the start of the cycle
        Node slow=head,fast=head;
        boolean hasCycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
            if(slow==fast){
                hasCycle=true;
                break;
            }
        }
        if(!hasCycle){
            return 0;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;//+1
            fast=fast.next;//+1
        }
        // slow and fast are now both pointing to start of cycle
        int len=1;
        fast=fast.next;//otherwise below loop will never run coz slow and fast have same value so shifting fast
        while(fast!=slow){
            fast=fast.next;
            len++;
        }
        return len;
    }
}
