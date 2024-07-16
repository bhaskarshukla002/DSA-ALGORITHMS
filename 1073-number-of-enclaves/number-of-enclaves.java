class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int visited[][]=new int[m][n];
        for(int i=0;i<n;i++){
            if(visited[0][i]!=1&&grid[0][i]==1){
                dfs(0,i, grid, visited);
            }
            if(visited[m-1][i]!=1&&grid[m-1][i]==1){
                dfs(m-1,i,grid,visited);
            }
        }
        for(int i=0;i<m;i++){
            if(visited[i][0]!=1&&grid[i][0]==1){
                dfs(i,0,grid,visited);
            }
            if(visited[i][n-1]!=1&&grid[i][n-1]==1){
                dfs(i,n-1,grid,visited);
            }
        }
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0&&grid[i][j]==1){
                    res++;
                }
            }
        }
        return res;
    }
    static int[][] dir={{-1,0},{0,-1},{0,1},{1,0}};
    void dfs(int r,int c,int[][] board,int visited[][]){
        visited[r][c]=1;
        for(int i=0;i<4;i++){
            int row=r+dir[i][0];
            int col=c+dir[i][1];
            if(row>=0&&row<visited.length&&col>=0&&col<visited[0].length&&visited[row][col]==0&&board[row][col]==1){
                dfs(row,col,board,visited);
            }
        }
    }
}