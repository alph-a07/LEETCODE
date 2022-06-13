class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        int mid = 0;

        while (low < high){
            mid = (low+high)/2;

            if (letters[mid] <= target)
                low = mid + 1;
            else
                high = mid;
        }

        if (target >= letters[high])
            return letters[(high+1)%(letters.length)];
        else
            return letters[low];
    }
}
