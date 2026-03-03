class Solution {
    Map<String, String> map = new HashMap<>();

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        dfs(digits, new StringBuilder(), 0);
        return result;
    }

    public void dfs(String digits, StringBuilder str, int idx){
        if(idx == digits.length()){
            result.add(str.toString());
            return;
        }
        String keypadOptions = map.get(String.valueOf(digits.charAt(idx)));
        for(char ch: keypadOptions.toCharArray()){
            str.append(ch);
            dfs(digits, str, idx+1);
            str.deleteCharAt(str.length() - 1);
        }

    }
}