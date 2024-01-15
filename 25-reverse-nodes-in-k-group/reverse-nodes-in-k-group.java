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
    public ListNode reverseKGroup(ListNode head, int k) {
        // if(k==1||head.next==null)
        // return head;
        // int n=0;
        ListNode temp=head;
        // ListNode next=null;
        ListNode prev=null;
        while(temp!=null){
            ListNode kth=findKthNode(temp,k);
            if(kth==null){
                if(prev!=null)
                prev.next=temp;
                break;
            }
            ListNode next=kth.next;
            kth.next=null;
            reverse(temp);
            if(head==temp){
                head=kth;
            }else
            prev.next=kth;
            prev=temp;
            temp=next;
        }
        return head;
    }
    ListNode findKthNode(ListNode head,int k){
        int ct=1;
        while(k>ct&&head!=null){
            // if|head.next==null)
            // return null;
            ct=ct+1;
            head=head.next;
        }
        return head;
    }
    void reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // return prev;
        // return curr;

    }
}