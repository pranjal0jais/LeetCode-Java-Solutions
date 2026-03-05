class Solution {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length-1, m;
        while(l<=h){
            m = (l+h)/2;
            if(nums[m] == target){
                return m;
            }
            // left sorted
            if(nums[l] <= nums[m]){
                if(nums[l] > target || nums[m] < target){
                    l = m+1;
                } else {
                    h = m-1;
                }
            }
            // right sorted
            else {
                if(nums[m] > target || nums[h] < target){
                    h = m-1;
                } else {
                    l = m+1;
                }
            }
        }
        return -1;
    }
}