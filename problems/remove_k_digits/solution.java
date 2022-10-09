class Solution {
    public String removeKdigits(String num, int k) {
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0;i<num.length();i++){
            if(stack.size() < 1 && num.charAt(i) !='0') stack.push(num.charAt(i));
            else{
               while (stack.size()>0 && k > 0 && stack.peek() > num.charAt(i)){
                   stack.pop();
                   k--;
               }
              if(stack.size()==0 && num.charAt(i) =='0') continue;
              stack.push(num.charAt(i));
            }
        }
       
       while(stack.size()>0 && k-- > 0) stack.pop();
       if(stack.size()==0) return "0";
       StringBuilder sb = new StringBuilder();
       while(stack.size()>0) sb.append(stack.pop());
       sb.reverse();
       return sb.toString();
    }
}