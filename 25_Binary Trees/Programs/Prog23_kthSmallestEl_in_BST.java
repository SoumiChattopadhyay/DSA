public class Prog23_kthSmallestEl_in_BST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    int count=0;
    public int kthSmallest(Node root, int k){
        return helper(root,k).data;
    }
    private Node helper(Node root,int k){
        if(root==null){
            return null;
        }

        //left processed first
        Node left = helper(root.left,k);
        if(left!=null){
            return left;
        }
        
        //then current node
        count++;
        if(count==k){
            return root;
        }
        
        //then right
        return helper(root.right,k);
    }
    public static void main(String[] args) {
        Node root=new Node(5);
        root.left=new Node(3);
        root.right=new Node(6);
        root.left.left=new Node(2);
        root.left.right=new Node(4);
        root.left.left.left=new Node(1);
        
        Prog23_kthSmallestEl_in_BST obj = new Prog23_kthSmallestEl_in_BST();
        System.out.println(obj.kthSmallest(root,3));
    }
}
