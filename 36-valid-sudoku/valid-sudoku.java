class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] row = new HashSet[N];
        HashSet<Character>[] col = new HashSet[N];
        HashSet<Character>[] box = new HashSet[N];

        for(int i = 0; i < N; i++){
            row[i] = new HashSet<Character>();
            col[i] = new HashSet<Character>();
            box[i] = new HashSet<Character>();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                char value = board[i][j];

                if(value == '.'){
                    continue;
                }

                if(row[i].contains(value)){
                    return false;
                }
                row[i].add(value);

                if(col[j].contains(value)){
                    return false;
                }
                col[j].add(value);

                int boxNo = (i/3)*3 + j/3;
                if(box[boxNo].contains(value)){
                    return false;
                }
                box[boxNo].add(value);
            }
        }
        return true;
    }
}