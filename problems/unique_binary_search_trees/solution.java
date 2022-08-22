class Solution {

    public int numTrees(int n) {
        int dp[] = new int[n + 1]; // dp[i] = num of BST for n = i

        dp[0] = 1;
        dp[1] = 1;

        // EXAMPLE
        // [1,2] => Two BST possible
        /* [1,2,3] => [root(1),left(×),right(2,3)] [root(2),left(1),right(3)] [root(3),left(1,2),right(×)]
        Hence dp[3] = dp[0]dp[2] + dp[1]dp[1] + dp[2]dp[0] */
        // This is the formula of Catalan numbers

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j]; // CATALAN NUMBERS
            }
        }
        return dp[n];
    }
}
