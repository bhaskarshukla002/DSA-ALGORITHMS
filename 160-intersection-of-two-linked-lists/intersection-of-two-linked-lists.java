/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) { 
        ListNode p=headA;
        int l1=0;
        int l2=0;
        while(p!=null)
        {
            p=p.next;
            l1=l1+1;
        }
        p=headB;
        while(p!=null)
        {
            p=p.next;
            l2=l2+1;
        }
        while(l1!=l2){
            if(l1>l2)
            {headA=headA.next;
            l1--;
            }else{
                headB=headB.next;
            l2--;
            }

        }
        while(headA!=null&&headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}