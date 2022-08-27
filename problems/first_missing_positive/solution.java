class Solution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // put elements in their correct position nums[i] = i+1
        // ignore non-positive elements
        // valid case can contain 1 -> n+1 integers
        // ignore numbers greater than length
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            // ignore
            if (x == i + 1 || x <= 0 || x > n) continue;
            // swap
            else if (x != nums[x - 1]) {
                nums[i] = nums[x - 1];
                nums[x - 1] = x;
                i--; // check again in next iteration for correct position
            }
        }

        int i = 0;
        // find incorrectly placed index
        for (; i < nums.length; i++) {
            if (nums[i] != i + 1) break;
        }
        return i + 1;
    }
}
