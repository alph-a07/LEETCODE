class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res += Math.pow(26,columnTitle.length()-1-i)*(columnTitle.charAt(i) - 64);
        }
        return res;
    }
}
