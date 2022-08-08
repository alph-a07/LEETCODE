class Solution {

    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        // first cell corresponds to empty string and pattern
        boolean[][] dp = new boolean[sl + 1][pl + 1]; // string -> rows, pattern -> columns
        // dp[i][j] = true if s.substring(0,i) matches with p.substring(0,j)

        dp[0][0] = true; // empty string <-> empty pattern

        // dp[i][0] = false (empty pattern)

        // empty string
        for (int i = 1; i < pl + 1; i++) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
        }

        // \U0001f4a1 (prev)* can be either converted to an empty string or (prev)(prev) or more
        // as we keep updating our dp we don't need to care about more than (prev)(prev)
        for (int i = 1; i < sl + 1; i++) {
            for (int j = 1; j < pl + 1; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                // If curr matches update according to prev
                if (sc == pc || pc == '.') dp[i][j] = dp[i - 1][j - 1];

                // If p has *
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 2]; // (prev)* = "" (2 characters less)
                    char prev = p.charAt(j - 2); 

                    // Now if prev matches with current in string
                    // Then a match can be made with (prev)*
                    // (prev)* = (prev)(prev)*
                    // one prev is matched so (prev)* should be checked with one character less string i.e. dp[i-1][j]
                    if (sc == prev || prev == '.') dp[i][j] |= dp[i - 1][j];
                }
            }
        }
        return dp[sl][pl];
    }
}
