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
    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return ans;
    }
    int ans=0;
    public NodeHelper maxSumBSTHelper(TreeNode root){
        if(root==null){
            return new NodeHelper(0,true,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        NodeHelper left=maxSumBSTHelper(root.left);
        NodeHelper right=maxSumBSTHelper(root.right);
        if(left.max<root.val&&root.val<right.min){
            ans=Math.max(ans,left.maxSum+right.maxSum+root.val);
            return new NodeHelper(left.maxSum+right.maxSum+root.val,true,Math.max(right.max,root.val),Math.min(left.min,root.val));
        }
        // return new NodeHelper(left.maxSum+right.maxSum+root.val,true,Math.max(right.max,root.val),Math.min(left.min,root.val));
        return new NodeHelper(Math.max(left.maxSum,right.maxSum),false,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}
public class NodeHelper{
    int maxSum;
    boolean isBst;
    int max;
    int min;
    public NodeHelper(int maxSum,boolean isBst,int max,int min){
        this.maxSum=maxSum;
        this.isBst=isBst;
        this.max=max;
        this.min=min;
    }
}