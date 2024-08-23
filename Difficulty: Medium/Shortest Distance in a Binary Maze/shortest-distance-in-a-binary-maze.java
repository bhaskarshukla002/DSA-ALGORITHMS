//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(source[0]==destination[0]&&source[1]==destination[1]) return 0;
        int n=grid.length;
        int m=grid[0].length;
        int dist[][]=new int[n][m];
        for (int[] row: dist)
        Arrays.fill(row, (int)1e9);
        dist[source[0]][source[1]]=0;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,source[0],source[1]});
        int direction[][]={{-1,0},{0,1},{1,0},{0,-1}};
        while(!q.isEmpty()){
            int d=q.peek()[0];
            int r=q.peek()[1];
            int c=q.peek()[2];
            q.remove();
            for(int[] dir:direction){
                int i=r+dir[0];
                int j=c+dir[1];
                if(i>=0&&i<n&&j>=0&&j<m&&grid[i][j]==1&&dist[i][j]>d+1){
                    dist[i][j]=d+1;
                if(i==destination[0]&&j==destination[1]){
                    return dist[i][j];
                }
                    q.add(new int[]{dist[i][j],i,j});
                }
            }
        }
        return -1;
    }
}
