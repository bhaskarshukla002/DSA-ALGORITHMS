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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> arr=new ArrayList<>();
        if(root==null)
            return arr;
        Queue<Pair<TreeNode,Pair<Integer,Integer>>> q=new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tree=new TreeMap<>();
        q.offer(new Pair<>(root,new Pair<>(0,0)));
        while(!q.isEmpty()){
            Pair<TreeNode,Pair<Integer,Integer>> p1=q.remove();
            Pair<Integer,Integer> p2=p1.getValue();
            TreeNode temp=p1.getKey();
            int v=p2.getKey();
            int l=p2.getValue();
            if(!tree.containsKey(v)){
                tree.put(v,new TreeMap<>());
            }
            if(!tree.get(v).containsKey(l)){
                tree.get(v).put(l,new PriorityQueue<>());
            }
            tree.get(v).get(l).offer(temp.val);
            if(temp.left!=null){
                q.offer(new Pair<>(temp.left,new Pair<>(v-1,l+1)));
            }
            if(temp.right!=null){
                q.offer(new Pair<>(temp.right,new Pair<>(v+1,l+1)));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> entry: tree.values()){
            arr.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:entry.values()){
                while(!nodes.isEmpty()){
                    arr.get(arr.size()-1).add(nodes.poll());
                }
            }
        }
        return arr;
    }
}
