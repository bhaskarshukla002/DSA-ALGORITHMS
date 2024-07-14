class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor==color)
        return image;
        int m=image.length;
        int n=image[0].length;
        int[][] dirs={{-1,0},{0,1},{0,-1},{1,0}};
        Queue<int[]> q=new LinkedList<>();
        image[sr][sc]=color;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int row=q.peek()[0];
                int col=q.peek()[1];
                q.remove();
                for(int j=0;j<4;j++){
                    int r=row+dirs[j][0];
                    int c=col+dirs[j][1];
                    if(r>=0&&r<m&&c>=0&&c<n&&image[r][c]==oldColor){
                        image[r][c]=color;
                        q.add(new int[]{r,c});
                    }
                }
            }
        }
        return image;
    }
}