class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        int dis[]=new int[n];
        for(int i=0;i<n;i++){
            dis[i]=Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        for(int[] it :times){
            adj.get(it[0]-1).add(new int[]{it[1]-1,it[2]});
        }
        dis[k-1]=0;
        q.add(new int[]{k-1,0});
        int ans=0;
        Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            int node=q.peek()[0];
            int d=q.peek()[1];
            q.poll();
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            ans= Math.max(ans,d);
            for(int[] it:adj.get(node)){
                int v=it[0];
                int w=it[1];
                if(!visited.contains(v)){
                    q.add(new int[]{v,d+w});
                }
            }    
        }
        return (visited.size()==n )? ans: -1;
        // return ans;
        
    }
}