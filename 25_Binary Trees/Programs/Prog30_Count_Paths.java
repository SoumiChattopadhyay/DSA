import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Prog30_Count_Paths {
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
    public int countPaths(int targetSum,Node root){//count all possible paths whose pathSum=targetSum.
       List<Integer> path = new ArrayList<>();
       return helper(targetSum,root,path);
    }
    private int helper(int targetSum,Node node,List<Integer> path){
        if(node==null){
            return 0;
        }
        path.add(node.data);
        int pathSum=0;
        int count=0;
        ListIterator<Integer> itr = path.listIterator(path.size());//mention where u will place the iterator. here its the last. so itr.previous()=last node
        while(itr.hasPrevious()){
            pathSum+=itr.previous();
            if(pathSum==targetSum){
            count++;
            }
        }
        count+=helper(targetSum, node.left, path)+helper(targetSum, node.right, path);
        //backtrack
        path.remove(path.size()-1);
        return count;
    }
    public static void main(String[] args) {
        Prog30_Count_Paths obj = new Prog30_Count_Paths();
        Node root=new Node(1);
        root.left=new Node(3);
        root.right=new Node(2);
        root.right.left=new Node(1);
        root.right.left.left=new Node(11);
        root.right.right=new Node(3);
        root.right.right.left=new Node(2);
        root.right.right.left.right=new Node(2);
        root.right.right.left.right.left=new Node(16);
        System.out.println(obj.countPaths(4,root));
    }
}
