class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // dfs based approach
    //     int V=graph.length;
    //     int[] vis=new int[V];
    //     int[] pathvis=new int[V];
    //     int[] check=new int[V];
        
    //     for(int i=0;i<V;i++){
    //         if(vis[i]==0){
    //             dfs(i,graph,vis,pathvis,check);
    //         }
    //     }
    //     List<Integer> ans=new ArrayList<>();
    //     for(int i=0;i<V;i++){
    //         if(check[i]==1){
    //             ans.add(i);
    //         }
    //     }
    //     return ans;
    // }
    
    // boolean dfs(int node,int[][] adj,int[] vis,int[] pathvis,int[] check){
    //     vis[node]=1;
    //     pathvis[node]=1;
    //     check[node]=0;
    //     for(int it:adj[node]){
    //         if(vis[it]==0){
    //             if(dfs(it,adj,vis,pathvis,check)==true){
    //                 check[node]=0;
    //                 return true;
    //             }
    //         }else if(pathvis[it]==1){
    //             check[node]=0;
    //             return true;
    //         }
    //     }
    //     pathvis[node]=0;
    //     check[node]=1;
    //     return false;
    // }
//      Bfs based toposort aproach
    
        List<List<Integer>> adjRev=new ArrayList<>();
        int V=graph.length;
        for(int i=0;i<V;i++){
            adjRev.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int it:graph[i]){
                adjRev.get(it).add(i);
            }
        }
        
        int[] inDegree=new int[V];
        
        for(int i=0;i<V;i++){
        for(int it:adjRev.get(i))
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
            for(int it:adjRev.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0)
                    q.add(it);
            }
        }
        Collections.sort(topo);
        return topo;
    }
    
}