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
    // TreeNode prev;
    public void flatten(TreeNode root) {
        // if(root==null){
        //     return;
        // }
        // flatten(root.right);
        // flatten(root.left);
        // root.right=prev;
        // root.left=null;
        // prev=root;
        
        while(root!=null){
            if(root.left!=null){
                TreeNode curr=root.left;
                while(curr.right!=null)
                curr=curr.right;
                curr.right=root.right;
                root.right=root.left;
                root.left=null;
            }
            root=root.right;
        }
    }
}