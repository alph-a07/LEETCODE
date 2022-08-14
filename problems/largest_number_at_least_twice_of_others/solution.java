class Solution {

    public int dominantIndex(int[] nums) {
        int max = 0;
        int maxN = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxN) {
                maxN = nums[i];
                max = i;
            }
        }

        int flag = 0;
        for (int n : nums) {
            if (maxN < 2 * n) flag++;
            if (flag > 1) return -1;
        }

        return max;
    }
}
