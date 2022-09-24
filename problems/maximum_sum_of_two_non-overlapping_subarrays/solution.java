class Solution {

    public int maxSumTwoNoOverlap(int[] nums, int x, int y) {
        // max of y after x and x after y
        return Math.max(helper(nums, x, y), helper(nums, y, x));
    }

    private int helper(int[] nums, int x, int y) {
        int x_sum = 0, y_sum = 0, ans;

        // initialise x and y length subarrays such that they don't overlap
        for (int i = 0; i < x + y; i++) {
            if (i < x) x_sum += nums[i]; 
            else y_sum += nums[i];
        }

        ans = x_sum+y_sum;
        
        // x_max = max sum subarray of length x till index i
        // y_sum = sum of y size subarray ending at index i
        for (int i = x + y, x_max = x_sum; i < nums.length; i++) {
            y_sum += nums[i] - nums[i - y];
            x_sum += nums[i - y] - nums[i - y - x];
            x_max = Math.max(x_max, x_sum);
            ans = Math.max(ans, x_max + y_sum);
        }
        return ans;
    }
}
