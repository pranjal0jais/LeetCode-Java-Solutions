class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            int[] count = new int[26];
            StringBuilder stringB = new StringBuilder();

            for(char ch: str.toCharArray()){
                count[ch - 'a']++;
            }

            for(int i: count){
                stringB.append('#').append(i);
            }

            if(!map.containsKey(stringB.toString())){
                map.put(stringB.toString(), new ArrayList<>());
            }
            map.get(stringB.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}