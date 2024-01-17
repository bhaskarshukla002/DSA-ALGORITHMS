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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
            return head;
        }
        int length=1;
        ListNode endNode=head;
        while(endNode.next!=null){
            endNode=endNode.next;
            ++length;
        }
        int end=length-(k%length);
        endNode.next=head;
        // endNode=head;
        while(end--!=0){
            endNode=endNode.next;
        }
        head=endNode.next;
        endNode.next=null;
        return head;
        
    }
}