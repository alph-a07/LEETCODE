class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Row-wise search
        for (int row = 0; row < matrix.length; row++) {
            // Check last element
            if (matrix[row][matrix[row].length - 1] == target)
                return true;

            // Check the row if last element is greater than target
            else if (matrix[row][matrix[row].length - 1] > target) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == target)
                        return true;
                }
            }
        }
        return false;
    }
}
