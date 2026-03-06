class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int target, int idx, List<Integer> curr){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            if(candidates[i] <= target){
                curr.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}