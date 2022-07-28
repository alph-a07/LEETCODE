class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int max = Integer.MIN_VALUE;

        while (low <= high) {
            int temp = (high - low) * Math.min(height[low], height[high]);
            max = Math.max(max,temp);
            
            // attempt to increase min height
            if (height[low] < height[high]) low++;

            // attempt to increase min height
            else if (height[low] > height[high]) high--;
            
            // attempt to increase both low and high height
            else {
                low++;
                high--;
            }
        }
        return max;
    }
}
