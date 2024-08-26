//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        List<List<int[]>> adj=new ArrayList<>();
        int ways[]=new int[n];
        long time[]=new long[n];
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->((int)a[0]-(int)b[0]));
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            time[i]=Long.MAX_VALUE;
            ways[i]=0;
        }
        for(int i=0;i<roads.size();i++){
            adj.get(roads.get(i).get(0)).add(new int[]{roads.get(i).get(1),roads.get(i).get(2)});
            adj.get(roads.get(i).get(1)).add(new int[]{roads.get(i).get(0),roads.get(i).get(2)});
        }
        time[0]=0;
        ways[0]=1;
        pq.add(new long[]{0,0});
        int mod=(int)(1e9+7);
        while(!pq.isEmpty()){
            long curr[]=pq.poll();
            int node=(int)curr[1];
            long totalTime=curr[0];
            for(int[] i:adj.get(node)){
                int v=i[0];
                long vTime=i[1];
                // ;
                if(totalTime+vTime<time[v]){
                    ways[v]=ways[node];
                    time[v]=totalTime+vTime;
                    pq.add(new long[]{time[v],v});
                }else if(totalTime+vTime==time[v]){
                    ways[v]=(ways[v]+ways[node])%mod;
                }
            }
        }
        
        return (ways[n-1]%mod);
    }
}
