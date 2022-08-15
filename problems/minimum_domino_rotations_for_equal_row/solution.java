class Solution {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countTops = new int[7]; // only top count
        int[] countBottoms = new int[7]; // only bottom count
        int[] countTotal = new int[7]; // top OR bottom count

        for (int i = 0; i < tops.length; i++) {
            // If top and bottom are same increase total count
            if (tops[i] == bottoms[i]) countTotal[tops[i]]++;
            // Else increase all counts
            else {
                countTops[tops[i]]++;
                countBottoms[bottoms[i]]++;
                countTotal[tops[i]]++;
                countTotal[bottoms[i]]++;
            }
        }

        // As countTotal[] counts total frequency of domino values
        // When it will be equal to total number of domino
        // Then our answer will be minimum of tops and bottoms count
        // And one of the row will display that particular i value
        for (int i = 1; i <= 6; i++) {
            if (countTotal[i] == tops.length) return Math.min(countTops[i], countBottoms[i]);
        }
        return -1;
    }
}
