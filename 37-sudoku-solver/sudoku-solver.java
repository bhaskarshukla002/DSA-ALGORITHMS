class Solution {
    public void solveSudoku(char[][] board) {
        helper(0,0,board);
    }
    boolean helper(int row,int col,char[][] board){
        if(row==9){
            return true;
        }
        if(col==9){
            return helper(row+1,0,board);
        }
        if(board[row][col]!='.'){
            return helper(row,col+1,board);
        }
        for(char i='1';i<='9';i++){
            if(validate(row,col,i,board)){
                board[row][col]=i;
                if(helper(row,col+1,board))
                return true;
                else{
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    boolean validate(int row,int col,char c,char[][] board){
        for(int i=0;i<9;i++){
            if(board[i][col]==c){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[row][i]==c){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
            return false;
        }
        return true;
    }
}