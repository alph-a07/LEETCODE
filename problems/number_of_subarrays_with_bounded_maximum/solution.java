class Solution {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = 0, end = 0, prev = 0, res = 0;

        // prev = number of valid subarrays ending at current index
        for (; end < nums.length; end++) {
            int curr = nums[end];

            // valid - count all subarrays \U0001f4a1ending at curr\U0001f4a1
            if (curr >= left && curr <= right) {
                prev = end - start + 1;
                res += prev;
            }
            // below range - can not contribute alone as out of range
            // hence will concatenate with previous element subarrays
            else if (curr < left) {
                res += prev;
            }
            // above range - can not contribute at all
            // ignore and start fresh
            else {
                start = end + 1;
                prev = 0;
            }
        }
        return res;
    }
}
