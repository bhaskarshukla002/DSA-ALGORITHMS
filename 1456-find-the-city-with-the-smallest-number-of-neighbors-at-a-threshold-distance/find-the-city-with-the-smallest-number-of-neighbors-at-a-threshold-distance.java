class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        int ans=-1;
        int ansCount=n;
        for(int i=0;i<n;i++){
            int[] res=dijkstra(i,n,adj);
            int count=0;
            for(int j=0;j<n;j++){
                if(res[j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=ansCount){
                ansCount=count;
                ans=i;
            }
        }
        return ans;
    }
    int[] dijkstra(int source,int n,List<List<int[]>> adj){
        int dis[]=new int[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        Arrays.fill(dis,Integer.MAX_VALUE);
        pq.add(new int[]{0,source});
        dis[source]=0;
        while(!pq.isEmpty()){
            int d=pq.peek()[0];
            int node=pq.peek()[1];
            pq.poll();
            for(int[] it:adj.get(node)){
                int v=it[0];
                int w=it[1];
                if(dis[v]>d+w){
                    dis[v]=d+w;
                    pq.add(new int[]{dis[v],v});
                }
            }
        }
        return dis;
    }
}