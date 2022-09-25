class Solution {

    public boolean isLongPressedName(String name, String typed) {
        if (name == typed) return true;

        int i = 0, j = 0;
        for (; i < name.length() && j < typed.length();) {
            // if current character in both strings are same
            if (name.charAt(i) == typed.charAt(j)) {
                char c = name.charAt(i);
                int n = 0;
                int t = 0;
                while (i < name.length() && name.charAt(i) == c) {
                    n++;
                    i++;
                }
                while (j < typed.length() && typed.charAt(j) == c) {
                    j++;
                    t++;
                }

                // Number of typed character should not be less than original number of characters
                if (t >= n) continue; else return false;
            } else return false;
        }

        // Return false if any extra characters left
        if (i < name.length() || j < typed.length()) return false;
        return true;
    }
}
