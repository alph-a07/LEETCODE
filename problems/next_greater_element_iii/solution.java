class Solution {

    // To find the next greater element
    // We need to change first smallest digit from right with its immediate greater digit
    public int nextGreaterElement(int n) {
        char[] nums = ("" + n).toCharArray(); // converted to array
        int l = nums.length;

        // first smallest digit from right
        // e.g. 402520 => 2 at index 2
        int i = l - 1;
        for (; i > 0; i--) {
            if (nums[i - 1] < nums[i]) break;
        }

        if (i == 0) return -1; // digits in descending order

        // smallest of greater digits than nums[i-1] (previously found)
        // e.g. 402520 => 5 at index 3
        int smallest = i;
        int j = i + 1;
        for (; j < l; j++) {
            if (nums[j] > nums[i - 1] && nums[j] <= nums[smallest]) smallest = j;
        }

        // swap the first smallest digit from right with its immediate greater digit right to it
        // e.g. 402520 => 405220
        char temp = nums[i - 1];
        nums[i - 1] = nums[smallest];
        nums[smallest] = temp;

        // sort the digits after (i-1)
        // 405220 => 405022
        Arrays.sort(nums, i, l);

        long res = Long.parseLong(String.valueOf(nums));

        return res <= Integer.MAX_VALUE ? (int) res : -1; // return if in int range
    }
}