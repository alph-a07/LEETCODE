class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] s = new int[seats.length+1];
        int n = s.length;
        s[0] = 1;
        System.arraycopy(seats,0,s,1,n-1);
        
        int start = 0,end=1;
        int max = Integer.MIN_VALUE;
        
        while(end < n){
            while(end < n && s[end]!=1) end++;
            
            if(start == 0) max = Math.max(max,end - 1);
            
            if(end < n) max = Math.max(max,(end-start)/2);
            else{
                max = Math.max(max, n-1-start);
                break;
            }
            
            start = end;
            end = start+1;
        }
        return max;
    }
}