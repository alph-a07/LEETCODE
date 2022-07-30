class Solution {
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;

        // one StringBuffer for each row
        StringBuffer[] array = new StringBuffer[nRows]; // array of StringBuffer

        for (int i = 0; i < array.length; i++) array[i] = new StringBuffer();

        int i = 0;
        // traversing each element and making zigzag in array
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                array[idx].append(c[i++]);

            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                array[idx].append(c[i++]);
        }

        // concatenate each row and return
        for (int idx = 1; idx < array.length; idx++)
            array[0].append(array[idx]);

        return array[0].toString();
    }
}
