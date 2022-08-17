class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boats = 0;
        int i = 0;
        int j = people.length - 1;
        
        while(i <=j){
            if (people[i] + people[j] <= limit){
                i++;
            }
            j--; // move j in any case because if now limit is exceeding, then with increasing i it will increase even more
            boats++; // boats will also increase in any case, with one person or two that depends
        }
        return boats;
    }
}
