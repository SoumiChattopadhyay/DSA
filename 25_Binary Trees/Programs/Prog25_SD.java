import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Prog25_SD {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    //TC=O(N)Even null children are added (2 for each leaf node), so total entries in the list = 2n + 1 (approx).
    //SC=O(N)List stores roughly 2n+1 entries → O(N). Recursive stack space for preorder traversal → O(H) where H is the height of the tree. So, SC = O(N+H)= O(N) in worst case (skewed tree).
    //Converts tree to list of strings
    public List<String> serialize(Node root){
        List<String> list = new ArrayList<>();
        helper(list, root);//u pass ref. var list so the changes helper() makes are visible on the original list
        return list;      //check below main function notes
    }
    private void helper(List<String> list,Node node){
        //store the tree in preorder traversal in the list. But, in the deserialize() how to know from the preorder list [3,2,4,1] the left and right of root-3. So also store nulls in list [3,2,null,null,4,1,null,null,null] so now u can form the tree back using only preorder list
        if(node==null){
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.data));

        helper(list, node.left);
        helper(list, node.right);
    }
    // TC=O(N)  Each element is processed once. 
    // SC=O(H) Recursive stack for tree reconstruction → O(H). The list is passed as reference (no copy) → not extra space. So, SC = O(H)=O(N) in worst case (skewed tree).
    //Converts list of strings to tree
    Node deserialize(List<String> list){
        Collections.reverse(list);
        Node node = helper2(list);
        return node;
    }
    Node helper2(List<String> list){
        // String str = list.remove(0);//This is an O(n) operation in an ArrayList because it has to shift all remaining elements one position left.So if your list has 1 million elements and you do this in a loop — it will be slow.
        String str = list.remove(list.size()-1);//This is a O(1) operation
        if(str.charAt(0)=='n'){
            return null;
        }
        Node node = new Node(Integer.parseInt(str));

        node.left = helper2(list);
        node.right = helper2(list);

        return node;
    }
    public static void main(String[] args) {
        Prog25_SD obj = new Prog25_SD();
        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.right.left=new Node(4);
        root.right.right=new Node(5);
        List<String> list = obj.serialize(root);
        System.out.println(list);
        obj.deserialize(list);
    }
}
// All objects in Java are passed by value — but the value is a reference to the object.
// What that means:
// In Java, everything is passed by value, including object references.
// So when you pass an object to a method:
// You're passing a copy of the reference, not the object itself.
// The method receives this reference and can modify the object it points to.
// But if the method reassigns the reference to point to a new object, the original reference outside the method won't change.

// list is a reference to an object → changes to it inside helper() affect the same list.
// root is also a reference to the Node tree → so yes, the method receives a reference to the same tree.

//  BUT — there's a key difference:
// If inside helper() you write: root = new Node(), that won’t change the original root in serialize() — because you're reassigning the reference, not changing the actual object.
// Same for list = new ArrayList<>() inside helper() — that won't affect the original list.

// if you do:
// root.val = 10; or root.left = new Node(); — the changes will reflect outside.

// But if you do:
// root = new Node(); // this only changes the local reference
// Now, root points to a new object.
// But the original reference in the caller method (e.g., serialize()) is unchanged.
// Because root (inside the method) is just a local variable.

// Collections.reverse(list):
// The method performs an in-place reversal of the list.
// It uses a two-pointer swap approach from both ends toward the center.

// So it does:
// for (int i = 0; i < n / 2; i++) {
//     swap(list[i], list[n - i - 1]);
// }
//TC=O(N) Each element is touched once (in a swap), so it’s linear time.
//SC=O(1) (in-place) No extra space is used — just temporary variables for swapping.