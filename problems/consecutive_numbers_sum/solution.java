class Solution {

    public int consecutiveNumbersSum(int n) {
        int i = 2, res = 0, sum = 0;

        while (sum < n) {
            sum += i - 1; // add prev integer to sum
            if ((n - sum) > 0 && (n - sum) % i == 0) res++; // check if remaining sum is divisible by current integer
            i++;
        }
        return res + 1; // +1 for the number itself
    }
}
