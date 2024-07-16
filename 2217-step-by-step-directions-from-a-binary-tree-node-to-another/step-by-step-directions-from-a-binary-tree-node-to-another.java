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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lac=getLAC(root,startValue,destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        // Find paths from LCA to start and destination nodes
        getPath(lac, startValue, pathToStart);
        getPath(lac, destValue, pathToDest);

        StringBuilder directions = new StringBuilder();

        // Add "U" for each step to go up from start to LCA
        directions.append("U".repeat(pathToStart.length()));
        directions.append(pathToDest);
        // for(int i=0;i<a.length();i++){
        //     b='U'+b;
        // }
        return directions.toString();
    }

    boolean getPath(TreeNode root,int dest,StringBuilder path){
        if(root==null){
            return false; 
        }
        if(root.val==dest){
            return true; 
        }
        path.append("L");
        if(getPath(root.left,dest,path)){
            return true;
        }
        path.deleteCharAt(path.length()-1);
        path.append("R");
        if (getPath(root.right,dest,path)){
            return true;
        }
        path.deleteCharAt(path.length()-1);
        return false;
    }

    TreeNode getLAC(TreeNode root,int startValue,int destValue){
        if(root==null||root.val==startValue||root.val==destValue){
            return root;
        }

        TreeNode left=getLAC(root.left,startValue,destValue);
        TreeNode right=getLAC(root.right,startValue,destValue);

        if(left==null){
            return right;
        }else if(right ==null){
            return left;
        }else {
            return root;
        }
    }
}