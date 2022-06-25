class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        // queue can't be directly instantiated
        Queue<Integer> queue = new PriorityQueue<>(); // FIFO

        for (Map.Entry<Character,Integer> entry: map.entrySet()){
            if (entry.getValue() == 1)
                queue.add(s.indexOf(entry.getKey()));
        }

        return queue.isEmpty() ? -1 : queue.remove();
    }
}
