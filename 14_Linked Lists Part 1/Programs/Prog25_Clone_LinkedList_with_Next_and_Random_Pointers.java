import java.util.HashMap;
import java.util.Set;

class Node{
    int data;
    Node next;
    Node random;

    // Constructor with only data
    Node(int data){
        this.data=data;
        this.next=null;
        this.random=null;
    }

    // Constructor with data,next,random
    Node(int data,Node next,Node random){
        this.data=data;
        this.next=next;
        this.random=random;
    }
}
public class Prog25_Clone_LinkedList_with_Next_and_Random_Pointers {
    // Brute Force
    // Algorithm:
    // 1) Iterate through the original linked list and for each node in the linked list create a new
    // node with the same data value as the original data. Map the original node to its copied 
    // node in the map.
    // 2) Iterate through the original list again but this time connect the pointers of the copied nodes in the same arrangement as the original node.
            // Get the copied node corresponding to the original node using the map.
            // Set the next pointer of the copied node to the copied node mapped to the original node’s next node.
            // Set the random pointer of the copied node to the original node’s next node copied from the map.
    // 3) Return the head of the deep copied list which is obtained by retrieving the copied nodes mapped to the original head from the map.
    /*
    Time Complexity: O(2N), where N is the number of nodes in the linked list. The linked list is traversed twice, once for creating copies of each node and for the second time to set the next and random pointers for each copied node. The time to access the nodes in the map is O(1) due to hashing.
    Space Complexity : O(N)+O(N), where N is the number of nodes in the linked list as all nodes are stored in the map to maintain mappings and the copied linked lists takes O(N) space as well.
    */
    public Node cloneLL_1(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node ptr = head;
        while(ptr!=null){//Step 1)
            map.put(ptr,new Node(ptr.data));
            ptr=ptr.next;
        }
        ptr=head;
        while(ptr!=null){//Step 2)
            Node ptrCopy = map.get(ptr);
            ptrCopy.next = map.getOrDefault(ptr.next, null);
            ptrCopy.random = map.getOrDefault(ptr.random, null);
            ptr=ptr.next;
        }
        
        return map.get(head);//head of the copied list
    }

    // Optimal 
    /*
    Algorithm:
    The previous approach uses an extra space complexity of creating mappings between the original and copied nodes. Instead of creating duplicate nodes and storing them in a map, insert it in between the original node and the next node for quick access without the need for additional space.

    Traverse the list again to set the random pointer of copied nodes to the corresponding copied node duplicating the original arrangement. As a final traversal, separate the copied and original nodes by detaching alternate nodes.

    1) Traverse the original node and create a copy of each node and insert it in between the original node and the next node.
    2) Traverse this modified list and for each original node that has a random pointer, set the copied node’s random pointer to the corresponding copies random node. If the original node’s random pointer is full, set the copied node’s random pointe to null as well.
    3) Traverse the modified list again and extract the copied nodes by breaking the links between the original nodes and the copied nodes. Revert the original list to its initial state by fixing the next pointers.
    4) Return the head of the deep copy obtained after extracting the copied nodes from the modified list.
    */
   /*
    Time Complexity: O(3N), where N is the number of nodes in the linked list. The algorithm makes three traversals of the linked list, once to create copies and insert them between original nodes, then to set the random pointers of the copied nodes to their appropriate copied nodes and then to separate the copied and original nodes.
    Space Complexity : O(N), where N is the number of nodes in the linked list as the only extra additional space allocated it to create the copied list without creating any other additional data structures.
   */
    public Node cloneLL_2(Node head){
        
        //Step 1) Insert copy of each node in between the original nodes
        Node ptr = head;
        while(ptr!=null){
            Node nextNode = ptr.next;
            Node copy = new Node(ptr.data);// Create a new node with the same data
            copy.next = nextNode;// Point the copy's next to the original node's next
            ptr.next = copy;// Point the original node's next to the copy
            ptr=nextNode;// Move to the next original node
        }
        
        //Step 2) Connect random pointers of the copied nodes
        ptr=head;
        while(ptr!=null){
            Node ptrCopy = ptr.next; // Access the copied node
            if(ptr.random!=null){//If the original node has a random pointer
                ptrCopy.random = ptr.random.next;//Point the copied node's random to the corresponding copied random node
            }else{
                ptrCopy.random=null;//Set the copied node's random to null if the original random is null
            }
            ptr=ptr.next.next;// Move to the next original node
        }

        // Step 3) Retrieve the deep copy of the linked list
        ptr=head;
        Node copyHead = new Node(-1);
        Node copyTail = copyHead;
        while(ptr!=null){
            Node ptrCopy = ptr.next;

            ptr.next = ptrCopy.next;// Restore original list

            copyTail.next = ptrCopy;// Append to copied list
            copyTail = ptrCopy;

            ptr=ptr.next;
        }
        copyTail.next=null;//guarantees the copied list is properly terminated. Old links are deleted.

        return copyHead.next;
    }
    public void printList(Node head){
        int i=0;
        while(head!=null){
            if(i>0) System.out.print(" --> "+head.data+","+((head.random!=null)?head.random.data:null));
            else System.out.print(head.data+","+((head.random!=null)?head.random.data:null));
            i++;
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        Prog25_Clone_LinkedList_with_Next_and_Random_Pointers obj = new Prog25_Clone_LinkedList_with_Next_and_Random_Pointers();
        obj.printList(head);
        // obj.printList(obj.cloneLL_1(head));
        obj.printList(obj.cloneLL_2(head));
    }
}
