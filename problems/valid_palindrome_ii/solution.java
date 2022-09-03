class Solution {

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        // two pointers
        while (start < end) {
            // if start and end are not equal
            // remove one of them and check which works
            if (s.charAt(start) != s.charAt(end)) 
                return isPallindrome(s.substring(start + 1, end + 1)) || isPallindrome(s.substring(start, end));
            start++;
            end--;
        }
        return true;
    }

    // check if passed string is a pallindrome
    boolean isPallindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
