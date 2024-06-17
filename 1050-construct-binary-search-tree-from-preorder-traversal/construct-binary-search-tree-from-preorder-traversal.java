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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return createTree(preorder,Integer.MAX_VALUE);
    }
    // int i;
    public TreeNode createTree(int[] preorder,int bound) {
        if(i>=preorder.length||preorder[i]>bound){
            return null;
        }
        TreeNode node=new TreeNode(preorder[i]);
        i++;
        node.left=createTree(preorder,node.val);
        node.right=createTree(preorder,bound);
        return node;
    }
}