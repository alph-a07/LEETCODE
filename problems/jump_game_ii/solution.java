class Solution {

    public int jump(int[] nums) {
        int jumps = 0,curr_end = 0,max_reach = 0;
        
        for(int i=0;i<nums.length-1;i++){
            max_reach = Math.max(max_reach,i + nums[i]);
            
            if(i == curr_end){
                jumps++;
                curr_end = max_reach;
            }
        }
        return jumps;
    }
}
