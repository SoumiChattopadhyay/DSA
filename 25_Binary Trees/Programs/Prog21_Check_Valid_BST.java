public class Prog21_Check_Valid_BST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    //TC=O()
    //SC=O()
    public boolean isValidBST(Node root) {
        return isValidBST_helper(root, null, null);
    }
    private boolean isValidBST_helper(Node node,Integer low,Integer high){
        if(node==null){
            return true;
        }
        if((low!=null && node.data<=low) || (high!=null && node.data>=high)){
            return false;
        }
        boolean leftTree = isValidBST_helper(node.left, low, node.data);
        boolean rightTree = isValidBST_helper(node.right,node.data,high);
        return leftTree && rightTree;
    } 
// int (primitive):
// Cannot be null
// Always has a value (default: 0)
// Good when you know the value will always be present

// Integer (wrapper class):
// Can be null
// Useful when you want to say "no value"/"unbounded"/"not set yet"
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(4);
        root.right.right=new Node(6);
    }
}
