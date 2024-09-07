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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
    //     return checkPath( head,root);
    // }
    // private boolean checkPath( ListNode head,TreeNode root) {
    //     if (root == null) return false;
        if(matchNode(head, root) ) return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right); 
    }
    boolean matchNode(ListNode head, TreeNode root) {
        if(head==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(root.val!=head.val){
            return false;
        }
        return matchNode(head.next , root.left)|| matchNode(head.next , root.right);
    }
}