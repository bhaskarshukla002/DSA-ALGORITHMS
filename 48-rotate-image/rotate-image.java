class Solution {
    public void rotate(int[][] matrix) {
        // int m=matrix.length;
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                matrix[i][j]=matrix[i][j]+matrix[j][i];
                matrix[j][i]=matrix[i][j]-matrix[j][i];
                matrix[i][j]=matrix[i][j]-matrix[j][i];
            }
            int l=0;
            int h=n-1;
            while(l<h){
                matrix[i][l]=matrix[i][l]+matrix[i][h];
                matrix[i][h]=matrix[i][l]-matrix[i][h];
                matrix[i][l]=matrix[i][l]-matrix[i][h];
                l++;
                h--;
            }
        }

    }
}