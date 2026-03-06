class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = -1, candidate2 = -1;
        int votes1 = 0, votes2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(candidate1 == nums[i]){
                votes1++;
            } else if(candidate2 == nums[i]){
                votes2++;
            } else if(votes1 == 0){
                candidate1 = nums[i];
                votes1 = 1;
            } else if(votes2 == 0){
                candidate2 = nums[i];
                votes2 = 1;
            } else {
                votes1--;
                votes2--;
            }
        }

        int count1 = 0;
        int count2 = 0;

        for(int num : nums){
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();

        int n = nums.length;

        if(count1 > n/3) result.add(candidate1);
        if(count2 > n/3) result.add(candidate2);

        return result;
    }
}