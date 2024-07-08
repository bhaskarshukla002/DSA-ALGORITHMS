class Solution {
    static int[][] dirs={{-1,0},{0,1},{0,-1},{1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(image[sr][sc]==color){
            return image;
        }
        image[sr][sc]=color;
        for(int[] dir:dirs){
            int r=sr+dir[0];
            int c=sc+dir[1];
            if(r>=0&&r<image.length&&c>=0&&c<image[0].length&& image[r][c] == oldColor)
            floodFill(image,r,c,color);
        }
        return image;
        
    }
}