class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        // Loop on nums
        // Traverse and make all nums[i-1] negative for all nums[i]
        // So if nums[i] remains positive after loop, states that i is not present in the array
        for (int i = 0; i < nums.length; i++) {
            // absolute values to avoid repeated negation and invalid(-ve) indices
            int index = Math.abs(nums[i]);
            nums[index - 1] = -1 * Math.abs(nums[index - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }
}