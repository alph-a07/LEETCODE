class Solution {

    // WIDTH = Max element - Min element
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long res = 0;
        long mod = 1000000007L;
        int n = nums.length;

        long[] p = new long[n];
        p[0] = 1;

        // Power array separately
        // Because Math.pow returns double
        for (int i = 1; i < n; i++) p[i] = (2 * p[i - 1]) % mod; // Number of subsequences = 2^n

        // At each iteration nums[i] will be maximum for all subsequences before i and minimum for all subsequences after i
        // We add total number of times for which nums[i] will be maximum
        // We subtract total number of times for which nums[i] will be minimum
        // At the end of the loop all max - min will be done and res will store the result
        for (int i = 0; i < n; i++) {
            res = (res + p[i] * nums[i] - p[n - i - 1] * nums[i]) % mod;
        }
        return (int) res;
    }
}
