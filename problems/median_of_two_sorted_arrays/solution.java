class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Assuming nums1 to be primary array(shorter length)
        if (nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0, high = n1;

        while (low <= high) {
            // partition at the middle in nums1
            int cut1 = (low + high) >> 1;
            // Remaining elements for the left half of merged array will be contributed by nums2
            int cut2 = ((n1 + n2 + 1) / 2) - cut1;

            // max of nums1 elements contributed to left half of merged array
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            // max of nums2 elements contributed to left half of merged array
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            // min of nums1 elements contributed to right half of merged array
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            // min of nums2 elements contributed to right half of merged array
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            // For a valid partitioning all the elements on the left half should be less than those on right
            // left1 <= right1 and left2 <= right2 as arrays are sorted
            if (left1 <= right2 && left2 <= right1) {
                // even length merged array
                if ((n1 + n2) % 2 == 0) return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                // odd length merged array
                // As left is left to the cut, in this case elements on left half be more and max og them will be median
                else return Math.max(left1, left2);
            }
            // reduce left1
            else if (left1 > right2) {
                high = cut1 - 1;
            }
            // increase left1
            else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
