class Solution {

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];

        int result = 0, open = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') open++; else {
                if (open > 0) {
                    dp[i] = dp[i - 1] + 2; // adding length
                    dp[i] += i - dp[i] >= 0 ? dp[i - dp[i]] : 0;
                    result = Math.max(result, dp[i]);
                    open--;
                }
            }
        }
        return result;
    }
}
