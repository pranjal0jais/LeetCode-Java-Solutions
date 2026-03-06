class Solution {

    public void backtrack(int start, int[] arr, int target, List<List<Integer>> ans, List<Integer> tempList){
        if(target == 0){
            ans.add(new ArrayList<>(tempList));
        }

        for(int i = start; i < arr.length; i++){
            if(i > start && arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i] > target){
                break;
            }

            tempList.add(arr[i]);
            backtrack(i+1, arr, target - arr[i], ans, tempList);
            tempList.remove(tempList.size() - 1);
        }
        
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); 
        backtrack(0, candidates, target, ans, new ArrayList<Integer>());
        return new ArrayList<>(ans);
    }
}