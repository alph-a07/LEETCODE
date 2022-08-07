class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prev = image[sr][sc];

        if (prev != color) floodFill(image, sr, sc, color, prev);
        
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int color, int prev) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != prev) return;

        image[sr][sc] = color;

        floodFill(image, sr + 1, sc, color, prev);
        floodFill(image, sr - 1, sc, color, prev);
        floodFill(image, sr, sc + 1, color, prev);
        floodFill(image, sr, sc - 1, color, prev);
    }
}
