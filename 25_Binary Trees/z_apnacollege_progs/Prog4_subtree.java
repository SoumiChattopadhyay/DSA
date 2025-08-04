package progs;
public class Prog4_subtree {
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
        public boolean isSubtree(Node root, Node subroot){
            if(root.data==subroot.data){
                
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
/* 
        1
       / \
      2   3
     / \   \
    4   5   6
    
*/
        Node subroot = new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
/*
         2  
        / \   
       4   5
*/
    BinaryTree t = new BinaryTree();
    System.out.println(t.isSubtree(root,subroot));
    }
}
