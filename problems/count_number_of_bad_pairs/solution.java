class Solution {

    public long countBadPairs(int[] nums) {
        HashMap<Integer, Long> map = new HashMap<>();
        long count = 0;
        long n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i] - i)) map.put(nums[i] - i,new Long(1)); 
            else{
                count += map.get(nums[i] -i);
                map.put(nums[i]-i,map.get(nums[i]-i)+1);
            } 
        }

        return (n*(n - 1) / 2) - count;
    }
}
