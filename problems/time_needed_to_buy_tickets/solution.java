class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int counter = 0;        

        while (tickets[k] != 0) {

            if (tickets[counter] != 0) {
                tickets[counter]--;
                time++;
            }
            counter = (counter + 1) % tickets.length;
        }
        return time;
    }
}
