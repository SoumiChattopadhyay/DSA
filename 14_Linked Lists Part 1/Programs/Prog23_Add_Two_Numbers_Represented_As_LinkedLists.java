class Node{
    int val;
    Node next;
    // Constructor with data and next pointer
    Node(int val,Node next){
        this.val=val;
        this.next=next;
    }
    // Constructor with only data
    Node(int val){
        this.val=val;
        this.next=null;
    }
}
public class Prog23_Add_Two_Numbers_Represented_As_LinkedLists {
    /*
    Algorithm:
        Create a dummy node that will act as the starting point of the new linked list.
        Create a temporary pointer and set it to the dummy node.
        Start with a carry value of 0.
        Loop through both linked lists until you reach the end of both, or until there is no carry left.
        At each step, add the values of the current nodes and the carry.
        Update the carry by dividing the total by 10.
        Create a new node with the last digit of the total (total % 10) and attach it to the next of the temporary pointer, then move the temporary pointer forward.
        Move both list pointers to their next nodes.
        After the loop ends, return the next node of the dummy (this is the head of the result list).
        The dummy node is used to make the code easier. Without it, extra conditions would be needed to handle the first node.
    */
    // Time Complexity: O(max(m,n)). Assume that m and n represent the length of l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.
    // Space Complexity: O(max(m,n)). The length of the new list is at most max(m,n)+1.
    public Node addTwoNumbers(Node head1, Node head2) {
        Node head3 = new Node(-1);
        Node temp = head3;
        int carry=0;
        while(head1!=null || head2!=null || carry!=0){
            int sum=0;
            if(head1!=null){
                sum+=head1.val;
                head1=head1.next;
            }
            if(head2!=null){
                sum+=head2.val;
                head2=head2.next;
            }
            sum+=carry;//add carry from prev iteration summation
            carry=sum/10;//(Anything under 10)/10 gives 0, but 10/10 gives 1, 21/10 gives 2
            Node newNode = new Node(sum%10);
            temp.next=newNode;
            temp=temp.next;
        }
        return head3.next;
    }
    public void printList(Node head){
        int i=0;
        while(head!=null){
            if(i>0) System.out.print("-->"+head.val);
            else System.out.print(head.val);
            i++;
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // List 1: 2 -> 4 -> 3
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        // List 2: 5 -> 6 -> 4
        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Prog23_Add_Two_Numbers_Represented_As_LinkedLists obj = new Prog23_Add_Two_Numbers_Represented_As_LinkedLists();
        obj.printList(obj.addTwoNumbers(head1, head2));

        // // List 1: 2 -> 4 -> 3
        // Node head1 = new Node(2);
        // head1.next = new Node(4);
        // head1.next.next = new Node(3);

        // // List 2: 5 -> 6 -> 8
        // Node head2 = new Node(5);
        // head2.next = new Node(6);
        // head2.next.next = new Node(4);

        // Prog23_Add_Two_Numbers_Represented_As_LinkedLists obj = new Prog23_Add_Two_Numbers_Represented_As_LinkedLists();
        // obj.printList(obj.addTwoNumbers(head1, head2));
    }
}
