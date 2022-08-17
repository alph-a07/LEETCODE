class Solution {

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;

        char[] arr = s.toCharArray();
        while (i <= j) {
            char left = arr[i];
            char right = arr[j];

            if (isVowel(left) && isVowel(right)) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            } else {
                if (!isVowel(left)) i++;
                if (!isVowel(right)) j--;
            }
        }
        return String.valueOf(arr);
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u' || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U');
    }
}
