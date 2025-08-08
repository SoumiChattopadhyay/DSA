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
    //SC=O(H)
//1.Recursion stack → height of tree = O(H)
//2.path list → at most H elements = O(H)
// So, O(H)+O(H)=O(2H)=O(H)

    //TC=O(N*H) 
// u visit every node in the binary tree once in the recursion
// In Inner while-loop with ListIterator - At each node, you may iterate backwards through the current path.
// In the worst case (skewed tree), the path length can be O(H), where H = height of the tree (H = N in worst case).
// So, at each node, you might do O(H) work.
// So, Total work = O(N*H)
// In a balanced tree → H = logN → O(NlogN)
// In a skewed tree → H = N → O(N²)}
    public int countPaths(int targetSum,Node root){//count all possible paths whose pathSum=targetSum.
       List<Integer> path = new ArrayList<>();
       return helper(targetSum,root,path);
    }
    private int helper(int targetSum,Node node,List<Integer> path){
        if(node==null){
            return 0;
        }
        path.add(node.data);
        long pathSum=0L;//to prevent integer overfow on integer addition
        long t=(long)targetSum;
        int count=0;//https://www.geeksforgeeks.org/java/listiterator-in-java/
        ListIterator<Integer> itr = path.listIterator(path.size());//mention where u will place the iterator. here its the last. so itr.previous()=last node
        while(itr.hasPrevious()){
            pathSum+=itr.previous();
            if(pathSum==t){
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
/*Wrong Answer
Input:
root =[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
targetSum = 0
Output=2
Expected=0 

1. The Problem: Integer Overflow
In Java:
int → 32-bit, max value = 2,147,483,647

If you go above that, it wraps around into negative numbers. This is called overflow.
int a = 1_000_000_000;
int b = 1_000_000_000;
int sum = a + b; // 2,000,000,000 ✅ still fine
sum += 1_000_000_000; // now = 3,000,000,000 ❌ exceeds max int
System.out.println(sum); // prints -1294967296 (wraps around)

So when your tree had many big values like 1_000_000_000, adding them together was 
pushing the sum beyond the limit, and it became a wrong negative number or even zero — 
which accidentally matched targetSum = 0 in your case.

What happened -
1,000,000,000
1,000,000,000
1,000,000,000
...
Target = 0

Backward sum (with int):

sum = 1,000,000,000  ✅ not 0
sum = 2,000,000,000  ✅ not 0
sum = 3,000,000,000  ❌ overflow to -1294967296
sum = ... eventually wraps to 0 ✅ accidental match
This is why your code thought there were 2 matches when actually there were 0.
*/