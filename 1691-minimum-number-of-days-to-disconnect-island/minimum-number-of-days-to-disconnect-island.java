// class Solution {
//     int[][] dir={{0,-1},{0,1},{-1,0},{1,0}};
//     public int minDays(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;

//         int initialCount=countIsland(grid);

//         if(initialCount!=1){
//             return 0;
//         }
//         for(int row=0;row<m;row++){
//             for(int col=0;col<n;col++){
//                 if(grid[row][col]==0) continue;
//                 grid[row][col]=0;
//                 int newCountIsland=countIsland(grid);
//                 if(newCountIsland != 1) return 1;

//                 grid[row][col]=1;
//             }
//         }
//         return 2;

//     }
//     int countIsland(int[][] grid){
//         int m=grid.length;
//         int n=grid[0].length;
//         int[][] vis=new int[m][n];
//         int isLand=0;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(vis[i][j]==0&&grid[i][j]==1){
//                     dfs(grid,vis,i,j);
//                     isLand++;
//                 }
//             }
//         }
//         return isLand;
//     }
//     private void dfs(int[][] grid,int[][] vis,int row,int col){
//         vis[row][col]=1;
//         for(int[] it:dir){
//             int nrow=row+it[0];
//             int ncol=col+it[1];
//             if(isValidLandCell(dir,vis,nrow,ncol)){
//                 dfs(grid,vis,nrow,ncol);
//             }
//         }
//     }
//     private boolean isValidLandCell(int[][] grid,int[][] vis, int row, int col) {
//         int rows = grid.length, cols = grid[0].length;
//         if(
//             row >= 0 &&
//             col >= 0 &&
//             row < rows &&
//             col < cols &&
//             grid[row][col] == 1 &&
//             vis[row][col]==0
//         ) return true;
//         else return false;
//     }
// }
class Solution {

    // Directions for adjacent cells: right, left, down, up
    private static final int[][] DIRECTIONS = {
        { 0, 1 },
        { 0, -1 },
        { 1, 0 },
        { -1, 0 },
    };

    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Count initial islands
        int initialIslandCount = countIslands(grid);

        // Already disconnected or no land
        if (initialIslandCount != 1) {
            return 0;
        }

        // Try removing each land cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) continue; // Skip water

                // Temporarily change to water
                grid[row][col] = 0;
                int newIslandCount = countIslands(grid);

                // Check if disconnected
                if (newIslandCount != 1) return 1;

                // Revert change
                grid[row][col] = 1;
            }
        }

        return 2;
    }

    private int countIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        // Iterate through all cells
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Found new island
                if (!visited[row][col] && grid[row][col] == 1) {
                    exploreIsland(grid, row, col, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    // Helper method to explore all cells of an island
    private void exploreIsland(
        int[][] grid,
        int row,
        int col,
        boolean[][] visited
    ) {
        visited[row][col] = true;

        // Check all adjacent cells
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            // Explore if valid land cell
            if (isValidLandCell(grid, newRow, newCol, visited)) {
                exploreIsland(grid, newRow, newCol, visited);
            }
        }
    }

    private boolean isValidLandCell(
        int[][] grid,
        int row,
        int col,
        boolean[][] visited
    ) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Check bounds, land, and not visited
        return (
            row >= 0 &&
            col >= 0 &&
            row < rows &&
            col < cols &&
            grid[row][col] == 1 &&
            !visited[row][col]
        );
    }
}