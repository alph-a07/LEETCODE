class Solution {
    static int singleNumber(int[] arr) {
        int res = 0;

        for (int a : arr) {
            res ^= a; // duplicate numbers will be converted to 0 after XOR and a ^ 0 = a
        }
        return res;
    }
}
