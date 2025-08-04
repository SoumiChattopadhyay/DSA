public class Prog8_RemoveCycle {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;

    public void removeCyclic(){//Floyd's Cycle Finding Algorithm
    boolean cycle=false;
        //step-1 : detect cyclic
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        
        if(cycle==false){
            return;
        }
        System.out.println(fast.data);
        //find 2nd meeting point
            slow=head;
            Node prev=null;//last node
            while(slow!=fast){
                prev=fast;//we need the node just before the cycle's starting point
                slow=slow.next;
                fast=fast.next;
            }//when slow=fast loop stops
            if(prev!=null){//if the loop never runs then prev stays null which happens if the cycle starts right at the head of the list.
                prev.next=null;
            }else{//traverse to the last node. for last node next is slow not null coz its a cycle
                while (fast.next!=slow) {  
                    fast=fast.next;
                }
                fast.next=null;
            }
    }
    public boolean isCyclic(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public void printList(){
        Node ptr=head;
        while(ptr!=null){
            System.out.print(ptr.data+"->");
            ptr=ptr.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        Prog8_RemoveCycle ll = new Prog8_RemoveCycle();
        head=new Node(1);
        head.next=new Node(2); 
        head.next.next=new Node(3);
        head.next.next.next=head.next;
        // head.next.next.next=null;
        // ll.printList();//infinite printing coz cyclic
        System.out.println(ll.isCyclic());
        ll.removeCyclic();
        System.out.println(ll.isCyclic());
        ll.printList();
    }
}
