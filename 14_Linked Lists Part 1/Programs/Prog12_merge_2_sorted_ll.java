public class Prog12_merge_2_sorted_ll {

 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp=new ListNode(-1);
        ListNode dummy=temp;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                dummy.next=list1;
                list1=list1.next;
            }else{
                dummy.next=list2;
                list2=list2.next;
            }
            dummy=dummy.next;
        }
        while(list1!=null){
            dummy.next=list1;
            list1=list1.next;
            dummy=dummy.next;
        }
        while(list2!=null){
            dummy.next=list2;
            list2=list2.next;
            dummy=dummy.next;
        }
        return temp.next;
    }
}
}
