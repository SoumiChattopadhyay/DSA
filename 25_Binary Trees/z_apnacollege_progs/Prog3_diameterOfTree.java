package progs;
public class Prog3_diameterOfTree {
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
        static class Info{
            int ht;
            int diam;
            public Info(int diam, int ht){
                this.ht=ht;
                this.diam=diam;
            }
        }
        public Info find_Diameter_of_tree(Node root){//TC=O(n) finding height and diam in same funct
            if(root==null){
                return new Info(0,0);
            }
            Info leftInfo = find_Diameter_of_tree(root.left);//will give info of left subtree
            Info rightInfo = find_Diameter_of_tree(root.right);//will give info of right subtree
            int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
            int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;
            return new Info(diam,ht);
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
    BinaryTree t = new BinaryTree();
    System.out.println(t.find_Diameter_of_tree(root).diam);
}
}