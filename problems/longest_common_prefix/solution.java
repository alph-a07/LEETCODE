class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        String first = strs[0];

        for (int i=0;i<first.length();i++){
            ans = ans + first.charAt(i);

            for (int j=1;j<strs.length;j++){
                if (i<strs[j].length() && strs[j].charAt(i) == first.charAt(i))
                    continue;
                else
                    return ans.substring(0,i);
            }
        }
        return ans;
    }
}