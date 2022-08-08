class Solution {

    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1]; // string -> rows, pattern -> columns
        // dp[i][j] = true if s.substring(i) can be matched with p.substring(j)

        dp[sl][pl] = true; // empty string <-> empty pattern

        // empty pattern can not be matched with non-empty string
        // for(int i=0;i<sl;i++)
        //     dp[i][pl] = false;

        // empty string, non-empty pattern
        // can only be matched with *
        for (int i = pl - 1; i >= 0; i--) {
            // curr is matched - update according to previous
            if (p.charAt(i) == '*') dp[sl][i] = dp[sl][i + 1];
        }

        for (int i = sl - 1; i >= 0; i--) {
            for (int j = pl - 1; j >= 0; j--) {
                char sc = s.charAt(i);
                char pc = p.charAt(j);

                // curr matched - update according to previous
                if (sc == pc || pc == '?') dp[i][j] = dp[i + 1][j + 1];

                // if pattern has *
                // // O(n)
                // if (pc == '*') {
                //     for (int k = i; k <= s.length(); k++) {
                //         dp[i][j] |= dp[k][j+1];
                //         // dp[i][j+1] -> * = ""
                //         // dp[i+1][j+1] -> * = s.substring(i,i+1);
                //         // dp[i+2][j+1] -> * = s.substring(i,i+2);
                //         // .
                //         // .
                //         // dp[i+k][j+1] -> * = s.substring(i,i+k);
                //     }
                // }

                // if pattern has *
                // O(1)
                if (pc == '*') {
                    // dp[i][j+1] - > * = ""
                    // dp[i+1][j] will only be true if one of dp[i+2][j]--dp[i+k][j] is true
                    // so for loop is not necessary
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
