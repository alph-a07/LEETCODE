public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;

        if (n == 0 || n == Math.pow(2,31)-1)
            return n;

        for (int i = 0; i < 32; i++) {
            res <<= 1; // left shift result to empty space for upcoming bit
            res |= ((n >> i) & 1); // get bit(single) from n
        }

        return res;
    }
}
