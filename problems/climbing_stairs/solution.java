class Solution {

    public int climbStairs(int n) {
        if(n<3)
            return n;
        
        int[] storage = new int[n + 1];
        storage[1] = 1;
        storage[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            storage[i] = storage[i - 1] + storage[i - 2];
        }

        return storage[n];
    }
}
