class Solution {
    public int longestPalindrome(String s) {
        int maxLength = 0;
        boolean isOddAdded = false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 0)
                maxLength += map.get(c);
            else {
                if (!isOddAdded) {
                    maxLength += map.get(c);
                    isOddAdded = true;
                } else
                    maxLength += (map.get(c) - 1);
            }
        }
        return maxLength;
    }
}
