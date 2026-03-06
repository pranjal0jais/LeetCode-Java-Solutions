class Solution {
    public int trap(int[] height) {
        int[] rightMax = new int[height.length];
        int[] leftMax = new int[height.length];
        int trap = 0;

        for(int i = 0; i < height.length; i++){
            if(i == 0){
                leftMax[i] = height[i];
                continue;
            }
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        for (int i = height.length-1; i >= 0; i--) {
            if(i == height.length-1){
                rightMax[i] = height[i];
                continue;
            }
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            trap += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trap;
    }
}