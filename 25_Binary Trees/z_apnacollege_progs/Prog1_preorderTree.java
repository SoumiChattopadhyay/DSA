package progs;
import java.util.*;
public class Prog1_preorderTree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        //Tree Traversals: 1) Recursive traversals(preorder,inorder,postorder) 2) Iterative(Level order traversal) - Queue data structure is used
        public static void preorderTraversal(Node root){//TC=O(n) each node is traversed once. Here root node printed first followed by left node and right node
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        public static void postorderTraversal(Node root){//TC=O(n) each node is traversed once. Here left node then right node then root node printed at last
            if(root==null){
                return;
            }
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data+" ");
        }
        public static void inorderTraversal(Node root){//TC=O(n) each node is traversed once. Here first left node is printed then root node is printed in b/w then right node.
            if(root==null){
                return;
            }
            inorderTraversal(root.left);
            System.out.print(root.data+" ");
            inorderTraversal(root.right);
        }
        //The level of a node in a binary tree is the distance (in edges) from the root to that node.
        public static void levelorderTraversal(Node root){//TC=O(2n)=O(n)
            //add root in queue, add null, remove & print root, add left and right, remove & print null, add another null.
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null)
                    q.add(currNode.left);
                    if(currNode.right!=null)
                    q.add(currNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTree.buildTree(nodes);
        // System.out.println(root.data);
        // BinaryTree.preorderTraversal(root);
        // BinaryTree.postorderTraversal(root);
        // BinaryTree.inorderTraversal(root);
        BinaryTree.levelorderTraversal(root);
    }
}