class Solution {

    public int maxProduct(int[] nums) {
        int nMax = nums[0]; // negative minimum
        int pMax = nums[0]; // positive maximum
        int max = nums[0]; // ans

        for (int i = 1; i < nums.length; i++) {
            int c = nums[i];

            // negative element
            if (c < 0) {
                int tmp1 = nMax;
                int tmp2 = pMax;

                // greedy in expanding subarray or starting new subarray
                pMax = Math.max(c, c * tmp1);
                nMax = Math.min(c, c * tmp2);
            } else {
                // greedy in expanding subarray or starting new subarray
                pMax = Math.max(c, pMax * c);
                nMax = Math.min(c, nMax * c);
            }
            max = Math.max(max, pMax); // update ans
        }
        return max;
    }
}
