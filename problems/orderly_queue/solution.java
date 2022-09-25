class Solution {

    public String orderlyQueue(String s, int k) {
        String ans = s;
        // Check by moving first letter at the end continuously 
        if (k == 1) {
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(i) + s.substring(0, i);

                if (temp.compareTo(ans) < 0) ans = temp;
            }
        } 
        // Any number of combinations are possible
        // Sorted string will be lexicographically smallest
        else {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            return new String(a);
        }
        return ans;
    }
}
