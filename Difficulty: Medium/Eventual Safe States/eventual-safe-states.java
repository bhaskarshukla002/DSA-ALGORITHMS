//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        // dfs based approach
    //     int[] vis=new int[V];
    //     int[] pathvis=new int[V];
    //     int[] check=new int[V];
        
        
    //     for(int i=0;i<V;i++){
    //         if(vis[i]==0){
    //             dfs(i,adj,vis,pathvis,check);
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
    
    // boolean dfs(int node,List<List<Integer>> adj,int[] vis,int[] pathvis,int[] check){
    //     vis[node]=1;
    //     pathvis[node]=1;
    //     check[node]=0;
    //     for(int it:adj.get(node)){
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
    
    // bfs based topological sort approach
    
        List<List<Integer>> adjRev=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjRev.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
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
