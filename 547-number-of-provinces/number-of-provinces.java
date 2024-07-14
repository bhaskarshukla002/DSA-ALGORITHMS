class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1)
                adj.get(i).add(j);
            }
        }
        int[] visited=new int[n];
        int ans=0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
            travers(visited,i,adj);
            ans++;
            }
        }
        return ans;
    }
    void travers(int[] visited,int src,List<List<Integer>> list){
        visited[src]=1;
        for(int i: list.get(src)){
            if(visited[i]==0){
                travers(visited,i,list);
            }
        }
    }
}