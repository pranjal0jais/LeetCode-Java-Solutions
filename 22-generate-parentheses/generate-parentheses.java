class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, 0, 0, ans, new StringBuilder());
        return ans;
    }

    void backtrack(int n, int open, int close, List<String> ans, StringBuilder temp){
        if(open == n && close == n){
            ans.add(temp.toString());
        }

        if(open < n){
            temp.append("(");
            backtrack(n, open+1, close, ans, temp);
            temp.deleteCharAt(temp.length() - 1);
        }

        if(open > close){
            temp.append(")");
            backtrack(n, open, close+1, ans, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}