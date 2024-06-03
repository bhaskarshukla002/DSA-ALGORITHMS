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
    List<Integer> ans=new ArrayList<>();
    // int level=0;
    public List<Integer> rightSideView(TreeNode root) {
        // if(root==null){
            // return ans;
        // }
        // if(level==ans.size()){
            // ans.add(root.val);
            // level++;
        // }
        // rightSideView(root.right);
        rightSideView(root,0);
        return ans;
    }
    // int level=0;
    public List<Integer> rightSideView(TreeNode root,int level) {
        if(root==null){
            return ans;
        }
        if(level==ans.size()){
            ans.add(root.val);
            // level++;
        }
        rightSideView(root.right,level+1);
        rightSideView(root.left,level+1);
        return ans;
    }

}