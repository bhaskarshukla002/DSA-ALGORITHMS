class KthLargest {
    private class Node{
    int value;
    Node left;
    Node right;
    int count=1;
    public Node(){};
    public Node(int value){
        this.value=value;
    }
}
    Node root;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int num:nums){
            root=addNumToBst(root,num);
        }
    }
    
    public int add(int val) {
        root=addNumToBst(root,val);
        return findNthLargest(root,k);
    }
    private int findNthLargest(Node node,int n){
        if(node==null) return Integer.MIN_VALUE;
        int rightCount=0;
        if(node.right!=null) rightCount=node.right.count;
        if(rightCount==n-1) return node.value;
        if(rightCount<n){
            return findNthLargest(node.left,n-rightCount-1);
        } else{
            return findNthLargest(node.right,n);
        }
    }

    private Node addNumToBst(Node node,int num){
        if(node==null){
            return new Node(num);
        }
        node.count=node.count+1;
        if(num<node.value){
            node.left=addNumToBst(node.left,num);
        }else{
            node.right=addNumToBst(node.right,num);
        }
        return node;

    }
    
    
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */