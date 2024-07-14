class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int oldColor = image[sr][sc];
        // if(oldColor==color)
        // return image;
        // int m=image.length;
        // int n=image[0].length;
        // int[][] dirs={{-1,0},{0,1},{0,-1},{1,0}};
        // Queue<int[]> q=new LinkedList<>();
        // image[sr][sc]=color;
        // q.add(new int[]{sr,sc});
        // while(!q.isEmpty()){
        //     int size=q.size();
        //     for(int i=0;i<size;i++){
        //        int row=q.peek()[0];
        //         int col=q.peek()[1];
        //         q.remove();
        //         for(int j=0;j<4;j++){
        //             int r=row+dirs[j][0];
        //             int c=col+dirs[j][1];
        //             if(r>=0&&r<m&&c>=0&&c<n&&image[r][c]==oldColor){
        //                 image[r][c]=color;
        //                 q.add(new int[]{r,c});
        //             }
        //         }
        //     }
        // }
         int oldColor = image[sr][sc];
         if(oldColor==color)
         return image;
         int m=image.length;
         int n=image[0].length;
         int[][] dirs={{-1,0},{0,1},{0,-1},{1,0}};
        dfs(image,sr,sc,m,n,dirs,oldColor,color);
        return image;
    }

    void dfs(int[][] image,int r,int c,int m,int n,int[][] dir,int oldColor,int color){
        image[r][c]=color;
        for(int i=0;i<4;i++){
            if(r+dir[i][0]>=0&&r+dir[i][0]<m&&c+dir[i][1]>=0&&c+dir[i][1]<n&&image[r+dir[i][0]][c+dir[i][1]]==oldColor){
                dfs(image,r+dir[i][0],c+dir[i][1],m,n,dir,oldColor,color);
            }
        }
    }
}