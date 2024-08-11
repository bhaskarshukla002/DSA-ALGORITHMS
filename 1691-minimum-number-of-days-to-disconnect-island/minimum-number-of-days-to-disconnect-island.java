class Solution {
    final int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public int minDays(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int initialCount=countIsland(grid);

        if(initialCount!=1){
            return 0;
        }
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                grid[row][col]=0;
                int newCountIsland=countIsland(grid);
                if(newCountIsland != 1) return 1;

                grid[row][col]=1;
            }
        }
        return 2;

    }
    int countIsland(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int isLand=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&grid[i][j]==1){
                    dfs(grid,vis,i,j);
                    isLand++;
                }
            }
        }
        return isLand;
    }
    private void dfs(int[][] grid,boolean[][] vis,int row,int col){
        vis[row][col]=true;
        for(int[] it:dir){
            int nrow=row+it[0];
            int ncol=col+it[1];
            if(isValidLandCell(grid,vis,nrow,ncol)){
                dfs(grid,vis,nrow,ncol);
            }
        }
    }
    private boolean isValidLandCell(int[][] grid,boolean[][] vis, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        if(
            row >= 0 &&
            col >= 0 &&
            row < rows &&
            col < cols &&
            grid[row][col] == 1 &&
            !vis[row][col]
        ) return true;
        else return false;
    }
}
