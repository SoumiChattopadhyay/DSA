public class Prog28_maxPathSum {
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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(Node root){
        helper(root);//dont return this value 
        return ans;
    }
    public int helper(Node node){
        if(node==null){
            return 0;
        }//Post Order Traversal of DFS
        int leftSum = helper(node.left);
        leftSum=Math.max(0,leftSum);
        int rightSum = helper(node.right);
        rightSum=Math.max(0,rightSum);
        int pathSum = leftSum+rightSum+node.data;//max path sum in its Left tree + max path sum in its Right tree + Current node = max path sum for the current node
        ans=Math.max(ans,pathSum);//update the global variable
        return Math.max(leftSum,rightSum)+node.data;//current node will send either the leftPathSum or rightPathSum to its parent node.
    }
    public static void main(String[] args) {
        
    }
}
