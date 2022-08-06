class Solution {

    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int row = m-2;row>=0;row--){
            grid[row][n-1] += grid[row+1][n-1]; 
        }
        
        for(int col = n-2;col>=0;col--){
            grid[m-1][col] += grid[m-1][col+1];
        }
        
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                grid[row][col] += Math.min(grid[row+1][col],grid[row][col+1]);
            }
        }
        return grid[0][0];
    }
}
