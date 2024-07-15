class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int visited[][]=new int[m][n];
        for(int i=0;i<n;i++){
            if(visited[0][i]!=1&&board[0][i]=='O'){
                dfs(0,i, board, visited);
            }
            if(visited[m-1][i]!=1&&board[m-1][i]=='O'){
                dfs(m-1,i,board,visited);
            }
        }
        for(int i=0;i<m;i++){
            if(visited[i][0]!=1&&board[i][0]=='O'){
                dfs(i,0,board,visited);
            }
            if(visited[i][n-1]!=1&&board[i][n-1]=='O'){
                dfs(i,n-1,board,visited);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
    int[][] dir={{-1,0},{0,-1},{0,1},{1,0}};
    void dfs(int r,int c,char[][] board,int visited[][]){
        visited[r][c]=1;
        for(int i=0;i<4;i++){
            int row=r+dir[i][0];
            int col=c+dir[i][1];
            if(row>=0&&row<visited.length&&col>=0&&col<visited[0].length&&visited[row][col]==0&&board[row][col]=='O'){
                dfs(row,col,board,visited);
            }
        }
    }
}