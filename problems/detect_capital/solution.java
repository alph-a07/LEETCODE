class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.charAt(0) >= 97) {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) <= 90)
                    return false;
            }
        } else {
            if (1 < word.length() && word.charAt(1) <= 90) {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) >= 97)
                        return false;
                }
            } else {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) <= 90)
                        return false;
                }
            }
        }
        return true;
    }
}
