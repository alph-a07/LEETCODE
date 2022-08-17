class Solution {

    public String multiply(String num1, String num2) {
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0')
            return "0";
        
        int l1 = num1.length();
        int l2 = num2.length();

        int[] res = new int[l1 + l2]; // max possible length of result
        String ans = "";
        int f = 0; // multiplication should be shifted left by one digit's place after each iteration
        
        // BASIC MULTIPLICATION
        for (int i = l2 - 1; i >= 0; i--) {
            // starting from right digit of num2
            int ival = num2.charAt(i) - '0';

            int carry = 0;
            int j = l1 - 1; // multiply starting with right digit of num1
            int k = l1 + l2 - 1 - f; // left shift
            while (j >= 0 || carry != 0) {
                int jval = j >= 0 ? num1.charAt(j) - '0' : 0;
                int product = ival * jval + carry + res[k]; // generalised
                res[k] = product % 10;
                carry = product / 10;
                j--;
                k--;
            }
            f++;
        }

        int i = 0;
        // leading zero removal
        for (; i < l1 + l2; i++) {
            if (res[i] != 0) break;
        }

        for (; i < l1 + l2; i++) ans += res[i];

        return ans;
    }
}
