class Solution {

    public int maximumSwap(int num) {
        char[] arr = ("" + num).toCharArray();
        int n = arr.length;
        int[] rightMax = new int[n]; // last index of max element from right

        rightMax[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            // If max occurs multiple times then we take last occurance
            // Because max will give more impact as we go left
            if (arr[i] <= arr[rightMax[i + 1]]) {
                rightMax[i] = rightMax[i + 1];
            } else rightMax[i] = i;
        }

        for (int i = 0; i < n; i++) {
            // Do the first possible swap and exit
            if (arr[i] < arr[rightMax[i]]) {
                int temp = (int) arr[i];
                arr[i] = arr[rightMax[i]];
                arr[rightMax[i]] = (char) temp;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(arr));
    }
}
