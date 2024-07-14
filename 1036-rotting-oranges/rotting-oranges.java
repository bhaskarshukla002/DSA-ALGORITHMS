class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        int visited[][]= new int[m][n];
        int tf=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    visited[i][j]=2;
                }
                if(grid[i][j]!=0){
                    tf++;
                }
            }
        }
        if(tf == 0) return 0;
        int tm=0;
        int drow[] = {0, 0, 1, -1};
        int dcol[] = {1, -1, 0, 0};
        int cnt=0;
        while(!q.isEmpty()){
            int size = q.size();
            cnt += size; 
            for(int k = 0 ; k < size ; k++) {
                int row=q.peek().getKey();
                int col=q.peek().getValue();
                // int t=q.peek().getValue();
                q.remove();
                // tm=Math.max(t,tm);
            for(int i=0;i<4;i++){
                int r=row+drow[i];
                int c=col+dcol[i];
                if(r>=0&&c>=0&&r<m&&c<n&&grid[r][c]==1&&visited[r][c]==0){
                    visited[r][c]=2;
                    q.add(new Pair<Integer,Integer>(r,c));
                }
            }
            }
            if(q.size()!=0){
                tm++;
            }
        }
        if(cnt!=tf){
            return -1;
        }
        return tm;        
    }
}