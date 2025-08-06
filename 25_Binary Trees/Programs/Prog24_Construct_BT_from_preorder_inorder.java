import java.util.Arrays;

public class Prog24_Construct_BT_from_preorder_inorder {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    public Node buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        int root_val = preorder[0];
        int root_idx=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root_val){
                root_idx=i;
            }
        }
        Node root = new Node(root_val);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, root_idx+1), Arrays.copyOfRange(inorder,0,root_idx));
        root.right = buildTree(Arrays.copyOfRange(preorder, root_idx+1, preorder.length), Arrays.copyOfRange(inorder,root_idx+1,inorder.length));
        return root;
    }
    public static void main(String[] args) {
        Node root=new Node(5);
        root.left=new Node(3);
        root.right=new Node(6);
        root.left.left=new Node(2);
        root.left.right=new Node(4);
        root.left.left.left=new Node(1);
        
        Prog24_Construct_BT_from_preorder_inorder obj = new Prog24_Construct_BT_from_preorder_inorder();
        System.out.println(obj.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7}));
    }
}
