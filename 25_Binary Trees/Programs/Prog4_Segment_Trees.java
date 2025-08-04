public class Prog4_Segment_Trees {
    //outer class Segment_Trees has a static inner class, non-static instance variable root and non-static instance method constructTree(). It has a constructor that calls constructTree() to form the tree in O(N) time complexity.
    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node(int startInterval, int endInterval){
            this.startInterval=startInterval;
            this.endInterval=endInterval;
        }
    }
    Node root;
    public Prog4_Segment_Trees(int arr[]){
        this.root=constructTree(arr,0,arr.length-1);
    }
    //TC=O(N)
    private Node constructTree(int arr[], int start, int end){
        //leaf node
        if(start==end){
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }
        //create new node with index you are at
        Node node = new Node(start,end);
        int mid=start+(end-start)/2;
        node.left=this.constructTree(arr,start,mid);
        node.right=this.constructTree(arr,mid+1,end);
        node.data = node.left.data + node.right.data;
        return node;
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str="";
        if(node.left!=null){
            str = str + "Interval=["+node.left.startInterval+","+node.left.endInterval+"] and data:" + node.left.data + " => ";
        }else{
            str = str + "No left child";
        }
        str = str + "Interval=[" + node.startInterval + "," + node.endInterval + "] and data:" + node.data + " <= ";
        if(node.right!=null){
            str = str + "Interval=["+node.right.startInterval+","+node.right.endInterval+"] and data:" + node.right.data + " => ";
        }else{
            str = str + "No right child";
        }
        System.out.println(str+"\n");
        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }
    }
    public int query(int qsi, int qei){
        return this.query(this.root,qsi,qei);
    }
    private int query(Node node, int qsi, int qei){
        //Case 1: Node interval completely inside query interval
        if(node.startInterval>=qsi && node.endInterval<=qei){
            return node.data;
        }
        //Case 2: Node interval completely outside query interval
        else if(node.startInterval>qei || node.endInterval<qsi){
            return 0;
        }
        //Case 3: Overlapping 
        //if(node.startInterval>=qsi && node.startInterval<=qei|| node.endInterval>=qsi && node.endInterval<=qei)
        else{
        return this.query(node.left,qsi,qei) + this.query(node.right,qsi,qei);
        }
    }
    public void update(int idx, int val){
        this.root.data=update(this.root,idx,val);
    }
    private int update(Node node,int idx,int val){
                    //if reached leaf node
            if(node.startInterval==idx && node.endInterval==idx){
            node.data=val;
            return val;
            }
        else if(idx>=node.startInterval && idx<=node.endInterval){
            int leftSum = this.update(node.left,idx,val);
            int rightSum = this.update(node.right,idx,val);
            node.data = leftSum + rightSum;
            return node.data;
        }
        else{
            return node.data;
        }
        }
    public static void main(String[] args) {
        int nums[]={3,8,7,6,-2,-8,4,9};
        Prog4_Segment_Trees tree = new Prog4_Segment_Trees(nums);
        tree.display();
        int sum = tree.query(2,6);
        System.out.println(sum);
        tree.update(3,14);
        tree.display();
    }
}

