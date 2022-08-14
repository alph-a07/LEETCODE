class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int temp1 = 1;
        // filling res array with product of elements left to curr element
        for (int i = 0; i < n; i++) {
            res[i] = temp1;
            temp1 *= nums[i];
        }

        // multiplying res array with product of elements right to curr element
        int temp2 = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= temp2;
            temp2 *= nums[i];
        }
        return res;
    }
}
