// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Prog5_BFS_Tree {
    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    Node root;
    static Queue<Node> q = new LinkedList<>();
    public Prog5_BFS_Tree(){
        
    }
    public void levelOrder(){
        q.add(this.root);
        levelOrderHelper();
    }
    private void levelOrderHelper(){
        //Base case
        if(q.isEmpty()){
            return;
        }
        Node node = q.remove();
        System.out.print(node.data+"->");
        if(node.left!=null)
        q.add(node.left);
        if(node.right!=null)
        q.add(node.right);
        
        levelOrderHelper();
    }
    public void insert(Scanner sc){
        //creating root here.
        System.out.println("Enter the value for root node:");
        int val = sc.nextInt();
        this.root = new Node(val);
        this.insert(sc,this.root);
    }
    private void insert(Scanner sc, Node node){
        System.out.println("Do you want to enter the left of "+node.data);
        boolean goLeft = sc.nextBoolean();
        if(goLeft){
            System.out.println("Enter the value for left of "+ node.data +":");
            int val = sc.nextInt();
            node.left = new Node(val);
            insert(sc,node.left);
        }
        System.out.println("Do you want to enter the right of "+node.data);
        boolean goRight = sc.nextBoolean();
        if(goRight){
            System.out.println("Enter the value for right of "+ node.data +":");
            int val = sc.nextInt();
            node.right = new Node(val);
            insert(sc,node.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Prog5_BFS_Tree tree = new Prog5_BFS_Tree();
        tree.insert(sc);
        tree.levelOrder();
    }
}
