public class Prog11_Detect_Cycle_and_Return_Cycle_Start_Node {
//  Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class Solution {
    public ListNode detectCycle(ListNode head) {
        boolean isCyclic=false;
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                isCyclic=true;
                break;
            }
        }
        if(isCyclic==false){
            return null;
        }
        slow=head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
}
