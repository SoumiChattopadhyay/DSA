/*
2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
A critical point in a linked list is defined as either a local maxima or a local minima.
A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].

Example 1:
Input: head = [3,1]
Output: [-1,-1]
Explanation: There are no critical points in [3,1].

Example 2:
Input: head = [5,3,1,2,5,1,2]
Output: [1,3]
Explanation: There are three critical points:
- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.

Example 3:
Input: head = [1,3,2,2,3,2,2,2,7]
Output: [3,3]
Explanation: There are two critical points:
- [1,3,2,2,3,2,2,2,7]: The second node is a local maxima because 3 is greater than 1 and 2.
- [1,3,2,2,3,2,2,2,7]: The fifth node is a local maxima because 3 is greater than 2 and 2.
Both the minimum and maximum distances are between the second and the fifth node.
Thus, minDistance and maxDistance is 5 - 2 = 3.
Note that the last node is not considered a local maxima because it does not have a next node.

Constraints:
The number of nodes in the list is in the range [2, 105].
1 <= Node.val <= 105
*/


/*
Explanation:
    Step 1 — Understand what we're looking for

        A node is critical if:
            current > previous AND current > next → local maximum
            current < previous AND current < next → local minimum

        So essentially, we're looking for places where the linked-list values change direction.

        For example:
        5 → 3 → 1 → 2 → 5 → 1 → 2
        
        Look at the direction of changes:
        5 ↓ 3 ↓ 1 ↑ 2 ↑ 5 ↓ 1 ↑ 2

        Whenever the direction changes:
        ↓ → ↑ = local minimum
        ↑ → ↓ = local maximum

        Those are our critical points
    
    Step 2 — Now think about the distances.
    
        Suppose the critical points occur at positions:  3, 5, 6

        Then:
        Distance between 3 and 5 = 2
        Distance between 5 and 6 = 1
        Distance between 3 and 6 = 3

        Therefore:
        minDistance = 1
        maxDistance = 3

        Notice something important:
        Do we actually need to store all the critical-point positions?
        Think about how we could calculate both distances while traversing the linked list only once.
        💡 Hint:
            For maxDistance, which two critical points will always give the maximum distance?
            And for minDistance, do you need to compare every pair, or only certain consecutive critical points?
        Answer:
            For maxdistance we need the dist b/w first critical point and the last one
            For mindistance we need dist b/w any of the consecutive critical points
        So, We don't need to remember every position.
        We really only need:
            First critical point position → needed for maxDistance
            Previous critical point position → needed to calculate the current minimum distance
            Current position → obviously
*/

import java.util.Arrays;

public class Day1_Min_and_Max_Dist_between_Critical_Points{
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val=val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution{
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            int[] ans = {-1,-1};
            
            ListNode prev=head;
            ListNode curr=head.next;

            int currPos=1;
            int firstCPpos=-1;
            int prevCPpos=-1;

            int minDist = Integer.MAX_VALUE;
            int maxDist = -1;
            
            while(curr.next!=null){
                // if curr node is a critical point (local maxima or local minima)
                if((curr.val>prev.val && curr.val>curr.next.val) || (curr.val<prev.val && curr.val<curr.next.val)){
                    // if this is the first critical point in the linkedlist
                    if(firstCPpos==-1){
                        //change the position of the firstCPpos variable from -1 to currPos
                        firstCPpos=currPos;
                    }else{
                        // find the dist b/w previous critical point(prev) and current critical point(curr), and then store it in minDist and maxDist accordingly
                        minDist=Math.min(minDist,currPos-prevCPpos);
                        maxDist=currPos-firstCPpos;
                    }
                    // update the previous critical point position to current critical point position
                    prevCPpos=currPos;
                }
                prev=curr;
                curr=curr.next;
                currPos++;
            }
            
            // check whether there are at least 2 critical points
            if(firstCPpos!=-1 && prevCPpos!=firstCPpos){//if not the case of no critical points existing and not the case of just 1 critical point existing
                ans[0]=minDist;
                ans[1]=maxDist;
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        int[] values = {5, 3, 1, 2, 5, 1, 2};

        Day1_Min_and_Max_Dist_between_Critical_Points obj = new Day1_Min_and_Max_Dist_between_Critical_Points();

        ListNode head = obj.new ListNode(values[0]);
        ListNode ptr = head;

        for(int i=1;i<values.length;i++){
            ptr.next = obj.new ListNode(values[i]);
            ptr=ptr.next;
        }

        Solution sol = obj.new Solution();
        System.out.println(Arrays.toString(sol.nodesBetweenCriticalPoints(head)));
    }
}