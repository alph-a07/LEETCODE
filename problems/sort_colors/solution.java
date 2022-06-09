class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, i = 0;
        while (i <= high) {
            if (nums[i] == 0) {
                swap(nums, low, i);
                i++;
                low++;
            } else if (nums[i] == 1) {
                i++;
                // when the element is 2 after that when swapping is done
                // no need to increase i as high is decreased and while loop will be iterating over high
            } else {
                swap(nums,i,high);
                high--;
            }
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}


