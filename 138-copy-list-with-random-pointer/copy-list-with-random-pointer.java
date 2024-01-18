/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        if(head.next==null){
            Node res=new Node(head.val);
            res.random=(head.random==null)?null:res;
            return res;
        }
        //  res=head;
        Node temp=head;
        while(temp!=null){
            Node next=temp.next;
            temp.next=new Node(temp.val);
            temp.next.next=next;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random=temp.random.next;
            }
            temp=temp.next.next;
        }
        temp=head;
        Node ans=new Node(0);
        Node res=ans;
        Node next;
        while(res!=null&&temp!=null){
            next=temp.next.next;
            res.next=temp.next;
            temp.next=next;
            res=res.next;
            temp=temp.next;
        }
        return ans.next;
    }
}