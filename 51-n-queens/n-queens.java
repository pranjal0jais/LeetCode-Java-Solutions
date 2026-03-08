class Solution {
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    Set<Integer> col = new HashSet<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String board[][] = new String[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = ".";
            }
        }
        dfs(board, n, 0);
        return result;
    }

    private void dfs(String[][] board, int n, int i){
        if(i == n){
            result.add(convert(board));
            return;
        }

        for(int j = 0; j < n; j++){
            if((posDiag.contains(i+j)) || (negDiag.contains(i-j)) || col.contains(j)){
                continue;
            }
            col.add(j);
            posDiag.add(i+j);
            negDiag.add(i-j);
            board[i][j] = "Q";
            
            dfs(board, n, i+1);

            col.remove(j);
            posDiag.remove(i+j);
            negDiag.remove(i-j);
            board[i][j] = ".";
        }
    }

    private List<String> convert(String[][] board){
        List<String> temp = new ArrayList<>();
        int n = board.length;
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        return temp;
    }
}