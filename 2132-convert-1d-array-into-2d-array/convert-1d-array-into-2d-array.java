class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length) return new int[][]{};
        int r=0;
        int c=0;
        int [][]res=new int[m][n];
        for(int i=0;i<original.length;i++){
            r=i/n;
            c=i%n;
            res[r][c]=original[i];
        }
        return res;
        
    }
}