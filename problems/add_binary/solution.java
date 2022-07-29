class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int an = 0;
            int bn = 0;

            if (i >= 0)
                an = a.charAt(i) - '0';
            if (j >= 0)
                bn = b.charAt(j) - '0';

            int tmp = an + bn + carry;

            res.insert(0, tmp % 2);
            carry = tmp / 2;
        }

        if (carry != 0)
            res.insert(0, carry);
        
        return res.toString();
    }
}
