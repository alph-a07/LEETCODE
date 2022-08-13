class Solution {

    public int maxChunksToSorted(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n+1];
        int chunks = 0;
        
        rightMin[n] = Integer.MAX_VALUE;
        // rightMin[i] = smallest element to right of nums[i]
        for(int i=n-1;i>=0;i--){
            rightMin[i] = Math.min(rightMin[i+1],nums[i]);    
        }
        
        int leftMax = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            leftMax = Math.max(leftMax,nums[i]); // greatest element to left of curr
            // if max element at left is even smaller than min element at right
            // it implies existance of a partition there
            if(leftMax <= rightMin[i+1]) chunks++;
        }
        return chunks;
    }
}