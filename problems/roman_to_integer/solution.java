class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        while (i <= s.length() - 1) {

            // handling for last character
            if (i == s.length() - 1) {
                ans += map.get(arr[i]);
                break;
            } else {
                if (map.get(arr[i]) < map.get(arr[i + 1])) {
                    ans += map.get(arr[i + 1]) - map.get(arr[i]);
                    i += 2;
                } else {
                    ans += map.get(arr[i]);
                    i++;
                }
            }
        }

        return ans;
    }
}