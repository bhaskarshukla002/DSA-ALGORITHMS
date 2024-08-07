//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		List<List<int[]>> adj=new ArrayList<>();
		for(int i=0;i<N;i++){
		    adj.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++){
		    adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
		}
		int vis[]=new int[N];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<N;i++){
		    if(vis[i]==0){
		        toposort(i,vis,adj,st);
		    }
		}
		int dis[]=new int[N];
		Arrays.fill(dis,(int)1e9);
		dis[0]=0;
		while(!st.isEmpty()){
		    int node=st.pop();
		    for(int[] it:adj.get(node)){
		        if(dis[node]+it[1]<dis[it[0]]){
		            dis[it[0]]=dis[node]+it[1];
		        }
		    }
		}
		
		for(int i=0;i<N;i++){
		    if(dis[i]==1e9){
		        dis[i]=-1;
		    }
		}
		return dis;
		
	}
    void toposort(int node,int[] vis,List<List<int[]>> adj,Stack<Integer> st){
        vis[node]=1;
        for(int[] it:adj.get(node)){
            if(vis[it[0]]==0){
		        toposort(it[0],vis,adj,st);
            }
        }
        st.push(node);
    }
}