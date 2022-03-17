class Solution {
public static int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int re = target - nums[i];

            if (map.containsKey(re) && map.get(re) != i)
                return new int[]{i, map.get(re)};
        }
        return new int[]{-1,-1};
    }
}