//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            // if(arr[0]!=arr[1])
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        int[] vis=new int[n];
        Arrays.fill(vis,(int)1e9);
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        vis[src]=0;
        while(!q.isEmpty()){
            int node=q.remove();
            for(int i:adj.get(node)){
                if(vis[node]+1<vis[i]){
                    vis[i]=1+vis[node];
                    q.add(i);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i]==1e9){
                vis[i]=-1;
            }
        }
        return vis;
        
    }
}