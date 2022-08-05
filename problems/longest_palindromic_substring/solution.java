class Solution {

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];
        // dp[i][j] -> true if substring(j,i+1) is a pallindrome

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                boolean equals = s.charAt(i) == s.charAt(j);

                if (i == j) {
                    dp[i][j] = true;
                } else if (i - j == 1) {
                    dp[i][j] = equals;
                } else if (equals && dp[i-1][j + 1]) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && i - j > end - start) {
                    start = j;
                    end = i;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
