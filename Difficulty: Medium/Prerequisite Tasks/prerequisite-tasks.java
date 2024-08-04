//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int V,int P, int[][] prerequisites)
    {
        // Your Code goes here
        List<List<Integer>> adj=new ArrayList<>();
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