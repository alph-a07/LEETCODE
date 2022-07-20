class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length())
            return ans;

        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            if (pMap.containsKey(p.charAt(i)))
                pMap.put(p.charAt(i), pMap.get(p.charAt(i)) + 1);
            else
                pMap.put(p.charAt(i), 1);

            if (sMap.containsKey(s.charAt(i)))
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            else
                sMap.put(s.charAt(i), 1);
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (pMap.equals(sMap))
                ans.add(i);

            if (sMap.get(s.charAt(i)) == 1)
                sMap.remove(s.charAt(i));
            else
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);

            if (i != s.length() - p.length()) {
                char c = s.charAt(i + p.length());
                if (sMap.containsKey(c))
                    sMap.put(c, sMap.get(c) + 1);
                else
                    sMap.put(c, 1);
            }
        }
        return ans;
    }
}