class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n]; // dp

        if (obstacleGrid[m - 1][n - 1] == 1) return 0;

        // fill end column with 1 (only one way - vertically down)
        for (int row = m - 1; row >= 0; row--) {
            if (obstacleGrid[row][n - 1] == 1) break;

            dp[row][n - 1] = 1;
        }

        // fill end row with 1 (only one way - horizontally right)
        for (int col = n - 1; col >= 0; col--) {
            if (obstacleGrid[m - 1][col] == 1) break;

            dp[m - 1][col] = 1;
        }

        // dp[i][j] = dp[i][j+1] + dp [i+1][j]
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                if (obstacleGrid[row][col] == 1) continue;

                dp[row][col] = dp[row][col + 1] + dp[row + 1][col];
            }
        }

        return dp[0][0];
    }
}
