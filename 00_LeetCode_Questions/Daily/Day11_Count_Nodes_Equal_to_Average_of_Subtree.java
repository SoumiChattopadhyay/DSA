/*
2265. Count Nodes Equal to Average of Subtree
Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
Note:
The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.

Example 1:
        4
       / \
      8   5
     / \   \
    0   1   6
Input: root = [4,8,5,0,1,null,6]
Output: 5
Explanation: 
For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
For the node with value 0: The average of its subtree is 0 / 1 = 0.
For the node with value 1: The average of its subtree is 1 / 1 = 1.
For the node with value 6: The average of its subtree is 6 / 1 = 6.

Example 2:
Input: root = [1]
Output: 1
Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.

Constraints:
The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000

Hint 1
What information do we need to calculate the average? We need the sum of the values and the number of values.

Hint 2
Create a recursive function that returns the size of a node’s subtree, and the sum of the values of its subtree.
*/

/*
Explanation

*/
public class Day11_Count_Nodes_Equal_to_Average_of_Subtree{
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        solve(root,count);
        return count;
    }
    public int[] solve(TreeNode root,int count){
        
    }
    public static void main(String[] args) {
        Day11_Count_Nodes_Equal_to_Average_of_Subtree obj = new Day11_Count_Nodes_Equal_to_Average_of_Subtree();
        TreeNode root = obj.new TreeNode(4);
        root.left = obj.new TreeNode(8);
        root.left.left = obj.new TreeNode(0);
        root.left.right = obj.new TreeNode(1);
        root.right = obj.new TreeNode(5);
        root.right.right = obj.new TreeNode(6);
        
        System.out.println(obj.averageOfSubtree(root));
    }
}