class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        // generate the triangle by creating each row
        for (int i = 1; i <= numRows; i++) {
            List<Integer> level = new ArrayList<>(); // current row

            for (int j = 1; j <= i; j++) {
                // first and last element is 1 on each row
                if (j == 1 || j == i) level.add(1);
                // compute other elements as the sum of elements above them
                else level.add(res.get(i - 2).get(j - 2) + res.get(i - 2).get(j - 1));
            }
            res.add(level);
        }
        return res;
    }
}
