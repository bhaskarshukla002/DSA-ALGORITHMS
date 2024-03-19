class Solution {
    public int orangesRotting(int[][] grid) {
        // Queue<Pair> q=new LinkedList<>();
        // int m=grid.length;
        // int n=grid[0].length;
        // int[][] vis=new int[m][n];
        // int mt=0;
        // int cnt=0;
        // int cntf=0;
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(grid[i][j]==2){
        //             q.add(new Pair(i,j,0));
        //             vis[i][j]=2;
        //         }
        //         if(grid[i][j]==1){
        //             cntf++;
        //         }
        //     }
        // }
        // int[] drow={-1,0,1,0};
        // int[] dcol={0,1,0,-1};
        // // int ans=0;
        // while(!q.isEmpty()){
        //     int r=q.peek().first;
        //     int c=q.peek().second;
        //     int t=q.peek().time;
        //     mt=Math.max(t,mt);
        //     q.remove();
        //     for(int i=0;i<4;i++){
        //         int nrow=r+drow[i];
        //         int ncol=c+dcol[i];
        //         if(ncol>=0 && ncol<n && nrow>=0 && nrow<m && vis[nrow][ncol]==0&&grid[nrow][ncol]==1)
        //         {
        //             q.add(new Pair(nrow,ncol,t+1));
        //             vis[ncol][nrow]=2;
        //             cnt++;
        //         }
        //     }
            
        // }
        

        // if(cnt!=cntf){
        //     return -1;
        // }

        // return mt;

        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                if(grid[i][j] != 0) {
                    count_fresh++;
                }
            }
        }
       
        if(count_fresh == 0) return 0;
        int countMin = 0, cnt = 0;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt += size; 
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int j = 0;j<4;j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || 
                    grid[x][y] == 2) continue;
                    
                    grid[x][y] = 2;
                    queue.offer(new int[]{x , y});
                }
            }
            if(queue.size() != 0) {
                countMin++;
            }
        }
        return count_fresh == cnt ? countMin : -1;
        
    }

    static class Pair {
    int first;
    int second;
    int time;

    Pair(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
} 
}