class Solution {

    public List<Integer> spiralOrder(int[][] m) {
        int r = m.length;
        int c = m[0].length;

        List<Integer> ans = new ArrayList<>();
        int sr = 0;
        int er = r - 1;
        int sc = 0;
        int ec = c - 1;
        while (sr <= er && sc <= ec) {
            
            // handling one element spiral
            if(sr == er && sc == ec){
                ans.add(m[sr][sc]);
                break;
            }
            
            // add one spiral
            for (int i = sc; i <= ec; i++) ans.add(m[sr][i]);
            for (int i = sr+1; i <= er; i++) ans.add(m[i][ec]);
            // avoid repetition
            for (int i = ec-1; i >= sc && sr !=er; i--) ans.add(m[er][i]);
            for (int i = er-1; i > sr && sc !=ec; i--) ans.add(m[i][sc]);

            // move inside
            sr++;
            sc++;
            er--;
            ec--;
        }
        return ans;
    }
}
