import java.util.Stack;

public class Prog32_DFS_using_Stacks {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    //Iterative approach of DFS using Stacks
    //TC=O(N) {visiting every node once}
    //SC=O(H) 
    public void preorder(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data+" ");
            if(node.right!=null)
            stack.push(node.right);
            if(node.left!=null)
            stack.push(node.left);
        }
    }
    public static void main(String[] args) {
        Prog32_DFS_using_Stacks obj = new Prog32_DFS_using_Stacks();
        Node root=new Node(1);
        root.left=new Node(3);
        root.right=new Node(2);
        root.right.left=new Node(1);
        root.right.left.left=new Node(11);
        root.right.right=new Node(3);
        root.right.right.left=new Node(2);
        root.right.right.left.right=new Node(2);
        root.right.right.left.right.left=new Node(16);

        obj.preorder(root);
    }
}
