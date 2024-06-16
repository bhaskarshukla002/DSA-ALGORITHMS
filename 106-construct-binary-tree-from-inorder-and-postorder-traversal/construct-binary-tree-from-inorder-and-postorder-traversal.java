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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        TreeNode node=helper(inorder,postorder,0,postorder.length-1,0,inorder.length-1,hm);
        return node;
    }
    TreeNode helper(int[] inorder, int[] postorder,int poststart,int postend,int instart,int inend,Map<Integer,Integer> hm)
    {
        if(postend<poststart||inend<instart){
            return null;
        }
        TreeNode root=new TreeNode(postorder[postend]);
        int left=hm.get(root.val);
        int numLeft=left-instart;
        root.left=helper(inorder,postorder,poststart,poststart+numLeft-1,instart,left-1,hm);
        root.right=helper(inorder,postorder,poststart
        +numLeft,postend-1,left+1,inend,hm);
        return root;
    }
}