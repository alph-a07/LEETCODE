class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        // low = min possible weight capacity of the ship
        // high = max possible weight capacity of the ship
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        // Binary search on min/max limits of ship capacity
        // Loop will stop when low == high
        while (low < high) {
            int mid = (low + high) / 2; // assuming mid as capacity
            int temp = 1; // ships needed
            int curr_weight = 0; // weight tracker

            // count number of ships of mid capacity required 
            for (int w : weights) {
                if (curr_weight + w > mid) {
                    temp += 1;
                    curr_weight = 0;
                }

                curr_weight += w;
            }

            // Number of days exceed - increase capacity
            if (temp > days) low = mid + 1;
            // Decrease capacity
            else high = mid;
        }
        return low;
    }
}
