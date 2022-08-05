class Solution {

    public boolean canJump(int[] nums) {
        int maxReachable = 0;

        for (int i = 0; i < nums.length; i++) {
            // -ve base case
            if (i > maxReachable) return false;

            // max reach from any index is i + nums[i]
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
}
