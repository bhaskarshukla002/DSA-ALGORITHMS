/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> hm=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)
        return null;
        Node visited=hm.get(node);
        if(visited!=null)
        return visited;
        Node clone=new Node(node.val);
        hm.put(node,clone);
        for(Node e:node.neighbors){
           clone.neighbors.add(cloneGraph(e)); 
        }
        return clone;        
    }
}