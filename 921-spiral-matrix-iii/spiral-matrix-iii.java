class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n=rows*cols;
        int ans[][]=new int[n][2];
        int idx=0;
        int curRow=rStart;
        int curCol=cStart;
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int step=1;
        int direction=0;
        while(idx<n){
            for(int i=0;i<2;i++){
                for(int j=0;j<step;j++){
                    if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                        ans[idx][0]=rStart;
                        ans[idx][1]=cStart;
                        ++idx;
                    }
                    rStart+=dir[direction][0];
                    cStart+=dir[direction][1];
                }
                direction = (direction+1)%4;
            }
            step++;
        }
       return ans; 
    }
}