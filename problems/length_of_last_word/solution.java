class Solution {
    public int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();
        int counter = 0;
        for (int i = arr.length - 1; i >= 0; i--) {

            if (i < arr.length - 1 && arr[i] == ' ' && arr[i + 1] != ' ')
                break;

                if (arr[i] == ' ')
                    continue;
                else
                    counter++;
        }
        return counter;
    }
}