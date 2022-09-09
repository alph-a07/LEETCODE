class Solution {

    public int maxDistToClosest(int[] seats) {
        // appending 1 before the original array
        int[] s = new int[seats.length + 1];
        int n = s.length;
        s[0] = 1;
        System.arraycopy(seats, 0, s, 1, n - 1);

        int start = 0, end = 1;
        int max = Integer.MIN_VALUE;

        while (end < n) {
            // work between intervals 1...1
            while (end < n && s[end] != 1) end++;

            // for the starting interval start is a dummy
            if (start == 0) max = Math.max(max, end - 1);

            // generic case
            if (end < n) max = Math.max(max, (end - start) / 2);
            
            // for the ending interval n-1 would be the best place to seat
            else {
                max = Math.max(max, n - 1 - start);
                break;
            }

            // move forward
            start = end;
            end = start + 1;
        }
        return max;
    }
}
