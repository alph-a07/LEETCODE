class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int temp = x;
        int remainder;
        int reverse = 0;
        while (temp != 0) {
            remainder = temp % 10;
            reverse = reverse * 10 + remainder;
            temp /= 10;
        }

        return x - reverse == 0;
    }

}