class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] ans=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        int[][] dis=new int[m][n];
        int[][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(mat[i][j]==0) {
                    vis[i][j]=1;
                    q.add(new int[]{i,j,0});
                } 
            }
        }
        // int dis=1;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
                int row=q.peek()[0];
                int col=q.peek()[1];
                int dist=q.peek()[2];
                q.remove();
                dis[row][col] = dist;
                for(int i=0;i<4;i++){
                    int r=row+dir[i][0];
                    int c=col+dir[i][1];
                    if(r>=0&&r<m&&c>=0&&c<n && mat[r][c]== 1 &&vis[r][c]==0){
                        vis[r][c]=1;
                        q.add(new int[]{r,c,dist+1});
                    }
                }
            }
        return dis;
    }
}