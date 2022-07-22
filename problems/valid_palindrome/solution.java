class Solution {
    public boolean isPalindrome(String s) {
        List<Character> list = alphanumeric(s);

        int low = 0;
        int high = list.size() - 1;

        while (low < high){
            if (list.get(low) == list.get(high)){
                low++;
                high--;
            }
            else
                return false;
        }
        return true;
    }

    private List<Character> alphanumeric(String s) {
        char[] sArr = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();

        for (char c : sArr) {
            if ((c >= 48 && c <= 57) || (c >= 97 && c <= 122))
                list.add(c);
            else if (c>=65 && c<=90)
                list.add((char) (c+32));
        }

        return list;
    }
}
