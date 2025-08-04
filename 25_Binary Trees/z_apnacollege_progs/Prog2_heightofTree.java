package progs;
public class Prog2_heightofTree{
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
        public int find_height_of_Tree(Node root){//TC=O(n) Each node is traversed one time or for each node height is calculated
            if(root==null){
                return 0;
            }
            int lh = find_height_of_Tree(root.left);
            int rh = find_height_of_Tree(root.right);
            int height = Math.max(lh,rh)+1;
            return height;
        }
        public int find_count_of_nodes(Node root){//TC=O(n) 
            if(root==null){
                return 0;
            }
            int lcount = find_count_of_nodes(root.left);
            int rcount = find_count_of_nodes(root.right);
            int count = lcount+rcount+1;
            return count;
        }
        public int find_sum_of_nodes(Node root){//TC=O(n)
            if(root==null){
                return 0;
            }
            int lsum = find_sum_of_nodes(root.left);
            int rsum = find_sum_of_nodes(root.right);
            int sum = lsum+rsum+root.data;
            return sum;
        }
        public int find_Diameter_of_tree(Node root){//TC=O(n^2) n.O(n) for each node its diam is found and TC to find its height is O(n)
            if(root==null){
                return 0;
            }
            int ld = find_Diameter_of_tree(root.left);//left diam of tree
            int rd = find_Diameter_of_tree(root.right);//right diam of tree
            int lh = find_height_of_Tree(root.left);//left height of tree
            int rh = find_height_of_Tree(root.right);//right height of tree
            int selfd = lh+rh+1;//self diam(Diameter when root is included)
            return Math.max(Math.max(ld,rd),selfd);
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
    System.out.println(t.find_height_of_Tree(root));
    System.out.println(t.find_count_of_nodes(root));
    System.out.println(t.find_sum_of_nodes(root));
    System.out.println(t.find_Diameter_of_tree(root));
    }
}