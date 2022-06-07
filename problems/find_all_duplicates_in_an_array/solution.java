class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {

            int next = Math.abs(nums[i-1]);

            if (nums[next -1]>0)
                nums[next-1]*=-1;
            else
                list.add(Math.abs(nums[i-1]));
        }
        return list;
    }
}
