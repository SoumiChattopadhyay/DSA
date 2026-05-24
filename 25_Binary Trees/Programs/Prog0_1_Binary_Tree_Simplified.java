import java.util.Scanner;

public class Prog0_1_Binary_Tree_Simplified {
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    Node root;
    void populate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Root Node value: ");
        int val = sc.nextInt();
        this.root = new Node(val);
        populate(sc,this.root);
    }
    void populate(Scanner sc, Node node){
        System.out.println("Do you wanna go to the left of node "+node.data);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of node "+node.data);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc,node.left);
        }
        System.out.println("Do you wanna go to the right of node "+node.data);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of node "+node.data);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc,node.right);
        }
    }
    void display(){
        display(this.root,"");
    }
    void display(Node node,String indent){
        if(node==null){
            return;
        }
        System.out.println(indent+node.data);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }
    void prettyDisplay(){
        prettyDisplay(this.root,0);
    }
    void prettyDisplay(Node node, int level){
        if(node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        for(int i=0;i<level;i++){
            System.out.print("|\t");
        }
        System.out.println("|----->"+node.data);
        prettyDisplay(node.left,level+1);
    }
    public static void main(String[] args) {
        Prog0_1_Binary_Tree_Simplified tree = new Prog0_1_Binary_Tree_Simplified();
        tree.populate();
        tree.display();
        tree.prettyDisplay();
    }
}

/*
Enter Root Node value: 
50
Do you wanna go to the left of node 50
true
Enter the value of the left of node 50
30
Do you wanna go to the left of node 30
true
Enter the value of the left of node 30
20
Do you wanna go to the left of node 20
false
Do you wanna go to the right of node 20
false
Do you wanna go to the right of node 30
true
Enter the value of the right of node 30
40
Do you wanna go to the left of node 40
false
Do you wanna go to the right of node 40
false
Do you wanna go to the right of node 50
true
Enter the value of the right of node 50
80
Do you wanna go to the left of node 80
true
Enter the value of the left of node 80
70
Do you wanna go to the left of node 70
false
Do you wanna go to the right of node 70
false
Do you wanna go to the right of node 80
true
Enter the value of the right of node 80
100
Do you wanna go to the left of node 100
false
Do you wanna go to the right of node 100
false
50
        30
                20
                40
        80
                70
                100 
                
                

|         |         |------->100
|         |------->80
|         |        |------->70
|
|------->50
|
|        |         |------->40
|        |------->30
|        |        |------->20
                */