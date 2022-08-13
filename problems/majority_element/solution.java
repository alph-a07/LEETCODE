class Solution {

    public int majorityElement(int[] nums) {
        int major = nums[0]; // assume
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if (major == curr) count++;
            // if count becomes 0, then assume current element as major and declare count = 1
            else if (count == 0) {
                count = 1;
                major = curr;
            } else count--;
        }
        return major;
    }
}
