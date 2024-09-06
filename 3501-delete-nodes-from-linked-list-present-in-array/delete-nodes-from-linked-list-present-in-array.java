/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        // while (head != null && valuesToRemove.contains(head.val)) {
        //     head = head.next;
        // }
        // if (head == null) {
        //     return null;
        // }
        ListNode curr=head;
        ListNode prev=head;
        while(curr!=null){
            if(set.contains(curr.val)){
                if(prev==curr){
                    head=head.next;
                    curr=curr.next;
                    prev=prev.next;    
                }else{
                    prev.next=curr.next;
                    // prev=curr; 
                    curr=curr.next;
                }
            }else{
                prev=curr; 
                curr=curr.next;
            }
        }
        return head;

    }
}