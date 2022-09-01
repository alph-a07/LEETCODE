class Solution {

    public String pushDominoes(String d) {
        if (d.length() == 1) return d; // edge case

        d = "L" + d + "R"; // no difference -- just to avoid IndexOutOfBoundException

        StringBuilder s = new StringBuilder(d);

        int start = 0, end = 1;

        // Work in intervals where .s are contained in between L or R
        while (end < s.length()) {
            // sc ... ec
            char sc = s.charAt(start);
            while (s.charAt(end) == '.') end++;
            char ec = s.charAt(end);

            if (end - start > 1) {
                // L ... L
                // make all L in between
                if (sc == 'L' && ec == 'L') {
                    while (start < end) s.setCharAt(++start, 'L');
                }
                // R ... R
                // make all R in between
                else if (sc == 'R' && ec == 'R') {
                    while (start < end) s.setCharAt(++start, 'R');
                }
                // R ... L
                // make left half R and right half L
                // middle element will be unaffacted if any
                else if (sc == 'R' && ec == 'L') {
                    int tmp = end;
                    while (start < tmp) {
                        s.setCharAt(start, 'R');
                        s.setCharAt(tmp, 'L');
                        start++;
                        tmp--;
                    }
                }
                // L ... R --> No impact
            }
            // move forward
            start = end;
            end = start + 1;
        }

        return s.substring(1, s.length() - 1); // remove extra added characters
    }
}
