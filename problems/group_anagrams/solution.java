// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         HashMap<HashMap<Character, Integer>, ArrayList<String>> result = new HashMap<>();
//         List<List<String>> ans = new ArrayList<>();

//         if (strs.length == 1) {
//             ArrayList<String> tmp = new ArrayList<>();
//             tmp.add(strs[0]);
//             ans.add(tmp);
//             return ans;
//         }

//         for (String str : strs) {
//             HashMap<Character, Integer> freq = new HashMap<>();
//             for (int i = 0; i < str.length(); i++) {
//                 char c = str.charAt(i);

//                 if (freq.containsKey(c)) freq.put(c, freq.get(c) + 1);
//                 else freq.put(c, 1);
//             }

//             ArrayList<String> tmp;
//             if (result.containsKey(freq)) {
//                 tmp = result.get(freq);
//             } else {
//                 tmp = new ArrayList<>();
//             }
//             tmp.add(str);
//             result.put(freq, tmp);
//         }

//         for (HashMap<Character, Integer> key : result.keySet()) {
//             ans.add(result.get(key));
//         }
//         return ans;
//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            String s1=strs[i];
            char[] arr=s1.toCharArray();
            Arrays.sort(arr);
            String str=new String(arr);
            
            if(map.containsKey(str)){
                map.get(str).add(s1); 
            }else{
                map.put(str,new ArrayList<>());
                map.get(str).add(s1);
            }
        }
        return new ArrayList<>(map.values());
    }
}