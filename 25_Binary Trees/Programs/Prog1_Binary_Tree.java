import java.util.Scanner;//needed
public class Prog1_Binary_Tree {
    //constructor
    public Prog1_Binary_Tree(){

    }
    private static class Node{//static inner class
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    private Node root;//non-static private instance variable of Prog1_Binary_Tree class
    public void populate(Scanner sc){//non-static member methods of Prog1_Binary_Tree class
        System.out.println("Enter the value:");
        this.root = new Node(sc.nextInt());//static member methods of a class cant access inner classes directly? They can if the inner classes are static
        populate(sc,this.root);
    }
    private void populate(Scanner sc, Node node){
        System.out.println("Do you want to enter the left of "+node.data+"?");
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of "+node.data);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc,node.left);
        }
        System.out.println("Do you want to enter the right of "+node.data+"?");
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of "+node.data);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc,node.right);
        }
    }
    public void display(){
        display(this.root,"");
    }
    private void display(Node node, String indent){
        if(node==null){
            return;
        }
        System.out.println(indent+node.data);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }
    public void prettyDisplay(){
        prettyDisplay(this.root,0);
    }
    private void prettyDisplay(Node node,int level){//Before printing left we are printing node, and before printing node we are printing right
        if(node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t");
            }
            System.out.println("|------>"+node.data);
        }else{
            System.out.println(node.data);
        }
        prettyDisplay(node.left,level+1);
    }
}
