class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int totalArea = 0;
        int leftMax = height[l];
        int rightMax = height[r];

        while(l < r){
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                totalArea += leftMax - height[l]; 
            }else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                totalArea += rightMax - height[r]; 
            }
        }

        return totalArea;
    }
}
