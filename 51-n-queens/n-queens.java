class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        board[i][j]='.';
        List<List<String>> ans=new ArrayList<>();
        helper(0,n,ans,board);
        return ans;
        
        
    }
    List<String> convertString(char[][] board,int n){
        List<String> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            String s="";
        for(int j=0;j<n;j++)
         s=s+board[i][j];
         ans.add(s);
        }
         return ans;
    }
    void helper(int start,int n,List<List<String>> ans,char[][] board){
        if(start==n){
            ans.add(convertString(board,n));
            return;
        }
        for(int i=0;i<n;i++){
            if(canPlace(start,i,board,n)){
                board[start][i]='Q';
                helper(start+1,n,ans,board);
                board[start][i]='.';
            }
        }
    }
    boolean canPlace(int row,int col,char[][] borad,int n){
        int r=row;
        int c=col;
        while(r>=0&&c>=0){
            if(borad[r][c]=='Q') return false;
            r--;
            c--;
        }
        r=row;
        c=col;
        while(r>=0){
            if(borad[r][c]=='Q') return false;
            r--;
        }
        r=row;
        c=col;
        while(r>=0&&c<n){
            if(borad[r][c]=='Q') return false;
            r--;
            c++;
        }
        return true;
    }
}