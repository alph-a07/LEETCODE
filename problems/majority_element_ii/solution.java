class Solution {

    // Boyer Moore's voting algorithm
    public List<Integer> majorityElement(int[] nums) {
        
        // As frequency > n/3 => Max 2 majority elements possisble
        int major1 = Integer.MIN_VALUE;
        int major2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        // voting
        for (int n : nums) {
            if (n == major1) count1++; 
            else if (n == major2) count2++; 
            else if (count1 == 0) {
                major1 = n;
                count1++;
            } else if (count2 == 0) {
                major2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        // vote counting
        for (int n : nums) {
            if (n == major1) count1++; 
            else if (n == major2) count2++;
        }

        ArrayList<Integer> res = new ArrayList<>();

        if (count1 > nums.length / 3) res.add(major1);
        if (count2 > nums.length / 3) res.add(major2);

        return res;
    }
}
