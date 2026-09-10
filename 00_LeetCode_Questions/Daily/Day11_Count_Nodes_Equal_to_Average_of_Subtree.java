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
1. What are we actually asked to find?
    For every node, we need to check:
    Is node.val equal to the average of all values in its subtree?
    
2. The important observation
    Suppose we are currently at node 5.
    To calculate the average of its subtree, we need:
        sum of subtree
        number of nodes in subtree
    But how do we get those?
        We can ask the left and right children to give us their information.

    For example:

       5
      / \
     6   2

    For node 5:
        Left subtree gives:
            sum = 6
            count = 1
        Right subtree gives:
            sum = 2
            count = 1

    Then node 5 combines them:
        sum = 5 + 6 + 2 = 13
        count = 1 + 1 + 1 = 3
        
        Average:  13 / 3 = 4

    Since: 5 != 4
    node 5 does not count.

3. This naturally suggests recursion
    At every node, we need information from its children.
    So we can create a recursive function: solve(node)
    which returns:
        sum of subtree
        count of nodes in subtree
    What should happen at a null node?
        If there is no node:
            sum = 0
            count = 0
        So:
        if (node == null)
            return new int[]{0, 0};

4. One very important detail
    Don't calculate the average using double.
    We don't need:
        double average = (double) sum / count;
    because the problem specifically wants the average rounded down.
    Java integer division already does this:
        int average = sum / count;

5. How do we keep track of the answer?
    Our recursive function needs to return:
        sum
        count
    But we also need a global answer(no. of nodes whose value is equal to the average of their subtree).
    So we can have a global variable:
        int result = 0;
    Whenever a node satisfies: node.val == sum / count
    we do: result++;
*/

/*
Remember this pattern:
For every node:
    1. Ask left child for:
       - subtree sum
       - subtree count

    2. Ask right child for:
       - subtree sum
       - subtree count

    3. Include current node:
       sum = leftSum + rightSum + node.val
       count = leftCount + rightCount + 1

    4. Calculate:
       average = sum / count

    5. If:
       node.val == average

       increment answer

    6. Return:
       sum and count
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
    int result=0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return result;
    }
    public int[] solve(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        //Call left child for sum and count
        int[] left = solve(root.left);
        // Call right child for sum and count
        int[] right = solve(root.right);
        // Include current node in sum and count
        int sum = left[0]+root.val+right[0];
        int count = left[1]+1+right[1];
        // Check if average is equal to current node value
        if(sum/count==root.val){
            result++;
        }
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