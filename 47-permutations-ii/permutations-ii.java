class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new boolean[nums.length], nums, new ArrayList<Integer>(), ans);
        return ans;
    }

    void backtrack(boolean[] visited, int[] nums, List<Integer> tempList, List<List<Integer>> ans){
        if(tempList.size() == nums.length){
            ans.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;

            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            tempList.add(nums[i]);
            visited[i] = true;
            backtrack(visited, nums, tempList, ans);
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}