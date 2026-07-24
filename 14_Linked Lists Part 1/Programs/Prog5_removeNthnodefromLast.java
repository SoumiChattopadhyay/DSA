public class Prog5_removeNthnodefromLast {
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;

    // Using for loop
    public Node removeNthFromEnd(Node head, int n) {
        int len = findLen(head);
        if(n==len){
            head=head.next;
            return head;
        }
        int delPos = len-n;
        Node ptr = head;
        for(int i=0;i<delPos-1;i++){
            ptr=ptr.next;
        }
        if(ptr.next!=null){
            ptr.next=ptr.next.next;
        }
        return head;
    }
    public int findLen(Node head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }

    // Using while loop
    public void removeNthNodefromLast(int n){
        int size=findSize();
        //Corner Case
        if(n==size){//means delete node at idx 0
            head=head.next;
            return;
        }
        Node ptr=head;
        int i=1;
        int idxToRemov=size-n;//considering index of el. from first. not considering el no.
        while(i<idxToRemov){//going till prev idx of idxToRemov
            i++;
            ptr=ptr.next;
        }

        if(ptr.next!=null)//if nth el to be removed from last is null
            ptr.next=ptr.next.next;
    }
    public int findSize(){
        Node ptr=head;
        int size=0;
        while(ptr!=null){
            size++;
            ptr=ptr.next;
        }
        return size;
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
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Prog5_removeNthnodefromLast ll = new Prog5_removeNthnodefromLast();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printList();
        ll.removeNthNodefromLast(2);//not passing idx, passing el no. from last. 1 means last el. 2 means second last el.
        ll.printList();
    }
}
