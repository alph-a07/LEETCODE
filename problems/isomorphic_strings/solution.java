class Solution {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic1(s, t) && isIsomorphic1(t, s);
    }

    private boolean isIsomorphic1(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                char prev = map.get(s.charAt(i));

                if (prev != t.charAt(i))
                    return false;
            }

            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
