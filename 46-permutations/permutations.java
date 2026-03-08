class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new HashSet<Integer>(), nums, new ArrayList<Integer>(), ans);
        return ans;
    }

    void backtrack(HashSet<Integer> visited, int[] nums, List<Integer> tempList, List<List<Integer>> ans){
        if(visited.size() == nums.length){
            ans.add(new ArrayList<>(tempList));
        }

        for(int i = 0; i < nums.length; i++){
            if(visited.contains(nums[i])){
                continue;
            }
            tempList.add(nums[i]);
            visited.add(nums[i]);
            backtrack(visited, nums, tempList, ans);
            visited.remove(nums[i]);
            tempList.remove(tempList.size() - 1);
        }
    }
}