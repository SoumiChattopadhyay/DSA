public class Prog27_Sum_Root_to_Leaf{
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    public int sumNumbers(Node root){
        return sumNumbers_helper(root,0);
    }
    public int sumNumbers_helper(Node root, int path){
        if(root==null){
            return 0;
        }
        path=path*10+root.data;
        if(root.left==null && root.right==null){//leaf node
            return path;
        }
        int leftPath = sumNumbers_helper(root.left, path);
        int rightPath = sumNumbers_helper(root.right, path);
        return leftPath+rightPath;
    }
    int path=0;
    public int sumNumbers2(Node root) {
        if(root==null){
            return 0;
        }
        path=(path*10)+root.data;
        if(root.left==null && root.right==null){
            return path;
        }
        int leftPath = sumNumbers(root.left);
        if(root.left!=null)
            path=(path-root.left.data)/10;
        int rightPath = sumNumbers(root.right);
        if(root.right!=null)        
            path=(path-root.right.data)/10;  
        return leftPath+rightPath;
    }
    public static void main(String[] args) {
        
    }
}  

