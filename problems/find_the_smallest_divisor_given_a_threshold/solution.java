class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1, max = 1000000;

        while (min < max) {
            int mid = (min + max) / 2;
            int temp = 0;

            for (int n : nums) temp += (n + mid - 1) / mid;

            if (temp > threshold) min = mid + 1; else max = mid;
        }
        return min;
    }
}
