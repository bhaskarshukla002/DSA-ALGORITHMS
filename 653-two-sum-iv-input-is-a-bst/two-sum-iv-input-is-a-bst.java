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
    public boolean findTarget(TreeNode root, int k) {
        // Sol 1:
        // HashSet<Integer> hs=new HashSet<>();
        // return findTargetHelper(root,k,hs);
        // Sol 2:
        BstIterator l=new BstIterator(root,false);
        BstIterator r=new BstIterator(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j==k){
                return true;
            }else if(i+j>k){
                j=r.next();
            }else{
                i=l.next();
            }
        }
        return false;
    }
    // public boolean findTargetHelper(TreeNode root, int k,HashSet<Integer> hs) {
    //     if(root==null)
    //     return false;
    //     if(hs.contains(k-root.val)){
    //         return true;
    //     }
    //     hs.add(root.val);
    //     return findTargetHelper(root.left,k,hs)||findTargetHelper(root.right,k,hs);
    // }
}
public class BstIterator{
    private Stack<TreeNode> st=new Stack<>();
    boolean reverse=true;
    public BstIterator(TreeNode root,boolean reverse){
        // this.st=st;
        this.reverse=reverse;
        pushAll(root);
    }

    public boolean hasNext(){
        return !st.isEmpty();
    }

    void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            if(reverse){
                root=root.right;
            }else{
                root=root.left;
            }
        }
    }

    public int next(){
        TreeNode temp=st.pop();
        if(reverse==false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }

}