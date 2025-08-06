public class Prog26_Path_Sum {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    int sum=0;
    public boolean hasPathSum(Node root, int targetSum) {
        if(root==null){//if(root=[] given i.e. no BT so irrespective of the targetSum(0 or an other no.) return false coz no BT so no path)
            return false;
        }
        sum+=root.data;
        if(root.left==null && root.right==null){//leaf node(On reaching leaf node only check the condition)
            if(targetSum==sum){
                return true;
            }
            sum-=root.data;
            return false;
        }
        boolean left = hasPathSum(root.left, targetSum);
        boolean right = hasPathSum(root.right, targetSum);
        
        if(left||right){
            return true;
        }else{
            sum-=root.data;
            return false;
        }
    }
    public boolean hasPathSum2(Node root, int targetSum) {
        if(root==null){//if(root=[] given i.e. no BT so irrespective of the targetSum(0 or an other no.) return false coz no BT so no path)
            return false;
        }
        if(root.data==targetSum && root.left==null && root.right==null){//leaf node(On reaching leaf node only check the condition)
            return true;
        }
        boolean left = hasPathSum2(root.left, targetSum-root.data);
        boolean right = hasPathSum2(root.right, targetSum-root.data);
        
        return left||right;
    }
    public static void main(String[] args) {
        Prog26_Path_Sum obj = new Prog26_Path_Sum();
        
        Node root = new Node(1);
        root.left=new Node(2);
        System.out.println(obj.hasPathSum(root, 1));//false
        
        System.out.println(obj.hasPathSum(null, 0));//false

        root=new Node(5);
        root.left=new Node(4);
        root.left.left=new Node(11);
        root.left.left.left=new Node(7);
        root.left.left.right=new Node(2);
        root.right=new Node(8);
        root.right.left=new Node(13);
        root.right.right=new Node(4);
        root.right.right.right=new Node(1);
        System.out.println(obj.hasPathSum(root, 22));//true
        System.out.println(obj.hasPathSum(root, 20));//false
        
    }
}  
