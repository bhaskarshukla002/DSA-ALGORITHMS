class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for(int row=0;row<m-2;row++){
            for(int col=0;col<n-2;col++){
                if(isMagixMat(row,col,grid)){
                    ans++;
                }
            }
        }
        return ans;
    }
    boolean isMagixMat(int row,int col,int[][] grid){
        int index[]=new int[]{0,1,2, 5, 8, 7, 6, 3};
        String sequence = "2943816729438167";
        String sequenceReversed = "7618349276183492";
        StringBuilder border=new StringBuilder();
        for(int i:index){
            int num=grid[row+i/3][col+(i%3)];
            border.append(num);
        }
        return (grid[row][col]%2==0)&&(sequence.contains(border.toString())||sequenceReversed.contains(border.toString()))&&(grid[row+1][col+1]==5);
    }
}