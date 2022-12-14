class Solution {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();

        int start = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int cMax = s.lastIndexOf(c); // min length needed for current character
            max = Math.max(max, cMax); // min length needed for all 0-i characters

            // partition will be made at MAX
            if (i == max) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
