class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                return c;
            }
            map.put(c, true);
        }
        return '\0';
    }
}
