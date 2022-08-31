class Solution {

    // ith row converted to (n-1-i)th column
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Convert rows into columns
        for (int i = 0; i < n; i++) {
            // Process just upper half triangle
            // Otherwise two swaps will make no change
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse rows to reverse order of columns
        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = n - 1;

            while (low < high) {
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }
}
