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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<Pair<Integer,TreeNode>> q=new LinkedList<>();
        if(root==null){
            return ans;
        }
        q.add(new Pair<>(1,root));
        while(!q.isEmpty()){
            Pair<Integer,TreeNode> p=q.remove();
            int l=p.getKey();
            TreeNode temp=p.getValue();
            if(ans.size()<l){
                ans.add(new ArrayList<>());
            }
            ans.get(l-1).add(temp.val);
            if(temp.left!=null){
                q.add(new Pair<>(l+1,temp.left));
            }
            if(temp.right!=null){
                q.add(new Pair<>(l+1,temp.right));
            }
        }
        return ans;
        
    }
}