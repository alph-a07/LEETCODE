class Solution {

    public int maxChunksToSorted(int[] nums) {
        int chunks = 0,n = nums.length,max = 0;
        
        // For sorted array nums[i] = i
        // max at ith iteration = max number in 0->i
        // max = i means there are 0->i numbers in o->i indices those can form a chunk
        for(int i =0;i<n;i++){
            max = Math.max(max,nums[i]);
            if(max == i) chunks++;
        }
        return chunks;
    }
}
