class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        for(int i=0;i< nums.length-1;i++){
            for(int j=i+1;j< nums.length;j++){
                if(nums[i]!=nums[j]&&nums[i]<nums[j]){
                    nums[i+1]=nums[j];
                    break;
                }
            }
        }
        for(int i=0;i< nums.length-1;i++){
            if(nums[i]<nums[i+1])
                k++;
            else
                break;
        }

        return k;
    }
}