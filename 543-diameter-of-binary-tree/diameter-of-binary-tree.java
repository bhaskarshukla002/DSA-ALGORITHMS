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
    int sum=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return sum;
    }
    int depth(TreeNode root){
        if(root==null){
            return 0;
        } 
        int lMax=depth(root.left);
        int rMax=depth(root.right);
        sum=Math.max(sum,lMax+rMax);
        return Math.max(lMax,rMax)+1;
    }
}