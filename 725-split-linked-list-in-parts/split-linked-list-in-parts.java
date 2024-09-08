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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res=new ListNode[k];
        if(head==null){
            return res;
        }
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        curr=head;
        ListNode prev=curr;
        int size=count/k;
        int mod=count%k;
        for(int i=0;i<k;i++){
            ListNode part=curr;
            int currSize=size;
            if(mod>0){
                mod--;
                currSize++;
            }
            int j=0;
            while(j<currSize){
                prev=curr;
                curr=curr.next;
                j++;
            }
            if (prev != null) {
                prev.next = null;
            }
            res[i] = part;

        }
        return res;
        
    }
}