public class Prog2_Binary_Search_Tree {
    public Prog2_Binary_Search_Tree() {

    }

    public static class Node {
        int data;
        Node left;
        Node right;
        int height;// additional property of Node class

        public Node(int data) {
            this.data = data;
        }
        public int getValue2() {
            return data;
        }
    }

    private static Node root;

    public void insert(int val) {
        // if(root==null){
        // root=new Node(val);
        // return;
        // }
        // insert(val,root);
        root = insert_Ret(val, root);
    }

    // private void insert(int val,Node node){
    // if(val<=node.data){
    // if(node.left==null){
    // node.left=new Node(val);
    // return;
    // }
    // insert(val,node.left);
    // }else{
    // if(node.right==null){
    // node.right=new Node(val);
    // return;
    // }
    // insert(val,node.right);
    // }
    // }
    private Node insert_Ret(int val, Node node) {
        if (node == null) {
            return new Node(val);// but if node is null, new node is created then returned
        }
        if (val <= node.data) {
            node.left = insert_Ret(val, node.left);
        } else {
            node.right = insert_Ret(val, node.right);
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;// new height is old height(which is
                                                                                // maximum of LHS height and RHS height)
                                                                                // +1(coz new el. is added)
        return node;// if node is not null, then the same node will be returned and no change
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;// if tree is empty
        }
        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && isBalanced(node.left)
                && isBalanced(node.right);
        // checks if a node's left child and right child have height difference <=1 and
        // also checks the same thing for the left subtree and right subtree.
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.data);
        display(node.left, "Left Child of " + node.data + " : ");
        display(node.right, "Right Child of " + node.data + " : ");
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 1; i < level; i++) {// if level is 1 we want 0 indentation, when level is 2 we want 1
                                             // indentation
                System.out.print("|\t");
            }
            System.out.println("|----->" + node.data);
        } else {
            System.out.println(node.data);
        }
        prettyDisplay(node.left, level + 1);
    }

    public int getHeight(Node node) {
        if (node == null) {
            return -1;// this must be -1 for isBalanced() funct
        }
        return node.height;
    }

    public int getValue(Node node) {
        if (node == null) {
            return -1;
        }
        return node.data;
    }

    public boolean isEmpty() {
        // if(root==null){
        // return true;
        // }
        // return false;
        return root == null;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    // populate()funct for sorted arrays
    public void populateSort(int[] nums, int si, int ei) {
        if (si > ei) {
            return;
        }
        int mid = si + (ei - si) / 2;// taking middle el.
        this.insert(nums[mid]);// inserting middle el.
        populateSort(nums, si, mid - 1);// dividing array into 2 parts
        populateSort(nums, mid + 1, ei);
    }

    public void preorder_Traversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ",");
        preorder_Traversal(node.left);
        preorder_Traversal(node.right);
    }

    public void inorder_Traversal(Node node) {
        if (node == null) {
            return;
        }
        inorder_Traversal(node.left);
        System.out.print(node.data + ",");
        inorder_Traversal(node.right);
    }

    public void postorder_Traversal(Node node) {
        if (node == null) {
            return;
        }
        postorder_Traversal(node.left);
        postorder_Traversal(node.right);
        System.out.print(node.data + ",");
    }
    public static void main(String[] args) {
        Prog2_Binary_Search_Tree tree = new Prog2_Binary_Search_Tree();
        // tree.insert(15);
        // tree.insert(10);
        // tree.insert(20);
        // tree.insert(5);
        // tree.insert(12);
        // tree.insert(16);
        // tree.insert(22);
        // tree.prettyDisplay();
        // tree.display();
        int nums[] = { 15, 10, 20, 5, 12, 16, 22 };
        tree.populate(nums);
        tree.prettyDisplay();
        tree.display();
        // int sorted_nums[]={1,2,3,4,5,6,7,8,9,10};
        // tree.populateSort(sorted_nums, 0, sorted_nums.length-1);
        // tree.prettyDisplay();
        // tree.display();
        tree.preorder_Traversal(root);
        System.out.println();
        tree.inorder_Traversal(root);
        System.out.println();
        tree.postorder_Traversal(root);
    }
}
