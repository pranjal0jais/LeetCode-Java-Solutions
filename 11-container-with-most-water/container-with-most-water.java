class Solution {
    public int maxArea(int[] height) {
        int w;
        int h;
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right){
            w = right - left;
            h = Math.min(height[left], height[right]);
            int area = w*h;
            maxArea = Math.max(area, maxArea);
            if(height[left] > height[right]){
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}