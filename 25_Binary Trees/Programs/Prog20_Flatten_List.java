import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Prog20_Flatten_List {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    //TC=O(N)
    //SC=O(1)
    public void flatten(Node root){
        if(root==null){
            return;
        }
        Node curr=root;
        while(curr!=null){
            if(curr.left!=null){
                Node temp=curr.left;
            while(temp.right!=null){
                temp=temp.right;
            }
            temp.right=curr.right;
            curr.right=curr.left;
            curr.left=null;
            }
            curr=curr.right;
        }

    }
    //TC=O(N) {Every node is pushed and popped exactly once.All operations inside the loop are O(1). So for N nodes => O(1)xN=O(N)}
    //SC=O(H) {The stack stores nodes on the current path of the tree.In the worst case (unbalanced tree), the height is N, so SC = O(N).In a balanced tree, height = log N, so SC = O(log N)}
        public void flatten2(Node root){
        if(root==null){
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        //store els. in stack
        while(!s.isEmpty()){
            Node curr=s.pop();
            if(curr.right!=null){//first push right
                s.push(curr.right);
            }
            if(curr.left!=null){//then push left, so that left is processed first(comes out first)
                s.push(curr.left);
            }
            //form new link
            if(!s.isEmpty()){
                curr.right=s.peek();
            }
            curr.left=null;
        }
    }
    //why not use a queue?
        //Using a Stack (LIFO):
        //You mimic recursion, which is how preorder naturally works.
        //You push right first, then left, so that left comes out first, so left is processed first(preorder)
        //Nodes come out in true preorder.(first root comes out then left comes out then right)
        // Ex: given below after main function
        //Unlike Queue(FIFO)-
        //You push left first then right,although left comes out first then right but you dont go deep into the left subtree first. Like in stack - So level order traversal happens not preorder traversal
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(4);
        root.right.right=new Node(6);
    }
}
//         1
//        / \
//       2   3
//      / \
//     4   5
//Stack(LIFO):
// Push 1
// Stack: [1]

// Pop 1 and → push right 3, push left 2
// Stack: [3, 2]

// Pop 2, then → push right 5, push left 4
// Stack: [3, 5, 4]

// Pop 4, then → push nothing as no children
// Stack: [3, 5]

// Pop 5, then → push nothing as no children
// Stack: [3]

// Pop 3, then → done

// Final Order: 1 2 4 5 3 (Preorder)


// ✅ Preorder Traversal = Depth-First
// Go deep into the left subtree first.
// Visit a node → go left → go left → go left → THEN backtrack to right.

// ❌ Queue-based traversal = Breadth-First (Level-order)
// Visit all nodes at the same depth, left to right.
// Only go deeper after finishing the current level.

