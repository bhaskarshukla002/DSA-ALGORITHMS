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
    public int maxDepth(TreeNode root) {
        int height=0;
        // Queue<Integer> q=new LinkedList<>();
        // q.add(root);
        height=helper(0,root);
        return height;
    }
    int helper(int l,TreeNode root){
        if(root==null){
            return l;
        }
        return Math.max(helper(l+1,root.left),helper(l+1,root.right));
    }
}