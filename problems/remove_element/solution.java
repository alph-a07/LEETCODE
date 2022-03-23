class Solution {
       public int removeElement(int[] nums, int val) {
        int low = 0;
        int high = nums.length - 1;

        if (nums.length == 0)
            return 0;

        while (low >= 0 && high <= nums.length-1 && low < high) {
            while (high>low && nums[high] == val)
                high--;

            if (nums[low] != val)
                low++;

            else {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        int counter = 0;
        for (int i = nums.length - 1; i >= 0 && nums[i] == val; i--) {
            counter++;
        }
        return nums.length - counter;
    }
}