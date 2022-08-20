class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        // int[] -> array or size 3
        // int[0] -> value
        // int[1] -> row number(Index of list)
        // int[2] -> column number(Index in list)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((i, j) -> i[0] - j[0]);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;

        int[] res = new int[2];

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).get(0) > max) max = nums.get(i).get(0);

            minHeap.offer(new int[] { nums.get(i).get(0), i, 0 });
        }

        while (!minHeap.isEmpty()) {
            int[] Min = minHeap.poll();

            if (max - Min[0] < range) {
                range = max - Min[0];
                res[0] = Min[0];
                res[1] = max;
            }

            int row = Min[1];
            int col = Min[2];
            if (row < nums.size() && col + 1 < nums.get(row).size()) {
                max = Math.max(max, nums.get(row).get(col + 1));

                minHeap.offer(new int[] { nums.get(row).get(col + 1), row, col + 1 });
            } else break;
        }
        return res;
    }
}
