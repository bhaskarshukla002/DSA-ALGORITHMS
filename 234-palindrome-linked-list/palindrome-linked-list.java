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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // ListNode second=slow.next;
        // slow.next=null;
        
        ListNode prev=null;
        ListNode curr=slow.next;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        slow.next=prev;
        slow=slow.next;
        // booolean ans=true;
        while(slow!=null){
            // if(slow==null&&head!=null){
                // return false;
            // }
            // if(head==null&&slow!=null)
            // return false;
            if(head.val!=slow.val){
                return false;
            }
            head=head.next;
            slow=slow.next;
        }
        return true;
        
    }
}