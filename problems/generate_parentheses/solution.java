class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n,res,0,0,"");        
        return res;
    }
    
    private void helper(int n,List<String> res,int open,int close,String s){
        if(s.length() == n*2){
            res.add(s);
            return;
        }
        
        if(open < n){
        helper(n,res,open+1,close,s+"(");
        }
        
        if(close < open){
            helper(n,res,open,close+1,s+")");
        }
    }
}
