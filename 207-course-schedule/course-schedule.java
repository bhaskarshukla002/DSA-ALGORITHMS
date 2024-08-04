class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int P=prerequisites.length;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<P;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] inDegree=new int[V];
        for(int i=0;i<V;i++){
        for(int it:adj.get(i))
            inDegree[it]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int it=0;it<V;it++){
            if(inDegree[it]==0)
                q.add(it);
        }
        int i=0;
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.remove();
            topo.add(node);
            i++;
            for(int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0)
                    q.add(it);
            }
        }
        
        if(i!=V) return false;
        return true;
    }
}