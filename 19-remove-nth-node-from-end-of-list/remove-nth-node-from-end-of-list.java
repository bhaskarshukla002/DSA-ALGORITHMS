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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode last=head;
        ListNode nth=head;
        ListNode prev=null;
        while(n>0){
            last=last.next;
            n=n-1;
        }
        while(last!=null){
            last=last.next;
            prev=nth;
            nth=nth.next;
        }
        if(prev==null)
        return head.next;
        prev.next=prev.next.next;
        return head;

        
    }
}