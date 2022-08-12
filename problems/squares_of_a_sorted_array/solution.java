class Solution {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n]; // resultant array

        // two pointers
        int left = 0;
        int right = nums.length - 1;

        // as array is sorted in non-decreasing order
        // abosolute values will be maximum at left and right ends and will decrease relatively towards center of the array
        // hence we should start filling from rear end in non-increasing order
        for (int i = res.length - 1; i >= 0; i--) {
            // if left square is greater -> add it and increase left
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            }
            // else -> add right square and decrease right
            else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
