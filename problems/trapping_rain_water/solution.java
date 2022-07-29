class Solution {
    public int trap(int[] height) {

        int water = 0;

        int[] prevGreatest = new int[height.length];
        int[] nextGreatest = new int[height.length];

        for (int i = 0; i < prevGreatest.length; i++) {
            if (i == 0) {
                prevGreatest[i] = height[i];
                nextGreatest[height.length - i - 1] = height[height.length - 1];
            } else {
                prevGreatest[i] = Math.max(height[i], prevGreatest[i - 1]);
                nextGreatest[height.length - i - 1] = Math.max(height[height.length - i - 1], nextGreatest[height.length - i]);
            }
        }

        for (int i = 1; i < height.length-1; i++) {
            water += Math.min(prevGreatest[i], nextGreatest[i]) - height[i];
        }
        return water;
    }

}

