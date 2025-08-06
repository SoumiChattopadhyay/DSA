public class Prog22_Lowest_Common_Ancestor {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
//Lowest Common ancestor of nodes p and q
public Node lowestCommonAncestor(Node root, Node p, Node q){
    if(root==null){
        return null;
    }
    if(root==p || root==q){
        return root;
    }
    Node left = lowestCommonAncestor(root.left,p,q);
    Node right = lowestCommonAncestor(root.right,p,q);
    if(left!=null && right!=null){
        return root;
    }
    return (left==null)?right:left;
}
    public static void main(String[] args) {
        Node root=new Node(3);
        root.left=new Node(5);
        root.right=new Node(1);
        root.left.left=new Node(6);
        root.left.right=new Node(2);
        root.left.right.left=new Node(7);
        root.left.right.right=new Node(4);
        root.right.left=new Node(0);
        root.right.right=new Node(8);
        Prog22_Lowest_Common_Ancestor lca = new Prog22_Lowest_Common_Ancestor();
        System.out.println(lca.lowestCommonAncestor(root,root.left,root.right.right).data);
    }
}
