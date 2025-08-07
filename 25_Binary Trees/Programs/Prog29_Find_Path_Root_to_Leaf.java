public class Prog29_Find_Path_Root_to_Leaf{
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    //TC=O(N)
    //SC=O(H)
    boolean findPath(Node root,int ar[]){
        if(root==null){//if root is null or on reaching null left child of node with right child only or vice versa
            return ar.length==0;
        }
        return helper(root,ar,0);
    }
    boolean helper(Node node,int ar[],int i){
        if(node==null){
            return false;
        }//Preorder Traversal of DFS
        if(i>=ar.length || node.data!=ar[i]){
            return false;
        }
        if(node.left==null && node.right==null && node.data==ar[i]){
            return true;
        }
        boolean left = helper(node.left, ar, i+1);
        boolean right = helper(node.right,ar,i+1);
        return left || right;
    }
    public static void main(String[] args) {
        
    }
}
