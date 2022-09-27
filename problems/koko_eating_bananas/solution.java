class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 1000000000;

        while (min < max) {
            int temp = 0; // Required hours
            int mid = (min + max) / 2; // Assume mid as current capacity
            
            // Calculate required hours
            for (int b : piles) temp += (b + mid - 1) / mid; // CEIL

            // If she's slow increase capacity
            if (temp > h) min = mid + 1;
            // Else decrease capacity
            else max = mid;
        }
        return min;
    }
}
