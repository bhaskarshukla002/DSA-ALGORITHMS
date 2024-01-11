/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node==null)
        return;
        if(node.next!=null && node.next.next==null){
            node.val=node.next.val;
            node.next=null;
            deleteNode(node.next);
        }else
        node.val=node.next.val;
        deleteNode(node.next);
    }
}