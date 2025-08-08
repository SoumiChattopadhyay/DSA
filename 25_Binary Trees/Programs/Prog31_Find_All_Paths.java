import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Prog31_Find_All_Paths {
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
    public List<List<Integer>> findPaths(int targetSum,Node root){//store all possible paths whose pathSum=targetSum.
       List<List<Integer>> paths = new ArrayList<>();
       List<Integer> path = new ArrayList<>();
       System.out.println("No. of paths="+helper(targetSum,root,path,paths));
       return paths;
    }
    private int helper(int targetSum,Node node,List<Integer> path,List<List<Integer>> paths){
        if(node==null){
            return 0;
        }
        path.add(node.data);
        int pathSum=0;
        int count=0;
        //https://www.geeksforgeeks.org/java/listiterator-in-java/
        ListIterator<Integer> itr = path.listIterator(path.size());//mention where u will place the iterator. here its the last. so itr.previous()=last node
        while(itr.hasPrevious()){
            pathSum+=itr.previous();
            if(pathSum==targetSum){
                int startIdx=itr.nextIndex();
                paths.add(new ArrayList<>(path.subList(startIdx,path.size())));
                count++;
            }
        }
       count+=helper(targetSum, node.left, path,paths)+helper(targetSum, node.right, path,paths);
        //backtrack
        path.remove(path.size()-1);
        return count;
    }
    public static void main(String[] args) {
        Prog31_Find_All_Paths obj = new Prog31_Find_All_Paths();
        Node root=new Node(1);
        root.left=new Node(3);
        root.right=new Node(2);
        root.right.left=new Node(1);
        root.right.left.left=new Node(11);
        root.right.right=new Node(3);
        root.right.right.left=new Node(2);
        root.right.right.left.right=new Node(2);
        root.right.right.left.right.left=new Node(16);

        System.out.println(obj.findPaths(4,root));
    }
}
/*Problem when u just do -
paths.add(path);
and get output : [[],[],[]]

1. You’re adding the same path object reference
When you do:
paths.add(path);
you’re not creating a new list — you’re just storing a pointer to the same path.

Later, when you backtrack and do:
path.remove(path.size() - 1);
it changes all the references inside paths, so they all end up empty []. 

Problem 2 : using startIdx = itr.previous(); gives java.lang.IndexOutOfBoundsException: fromIndex = -1
In your while (itr.hasPrevious()) loop, when you finally move to the very first element 
and call itr.previous(), then itr.previousIndex() becomes -1 on the next step

When u call itr.previous() it returns the previous value 
but after this the cursor also moves backward
So on calling itr.nextIndex() u will get the index of the node u were at before u called itr.previous() */