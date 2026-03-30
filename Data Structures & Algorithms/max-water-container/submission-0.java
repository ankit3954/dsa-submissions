class Solution {
    public int maxArea(int[] heights) {
        int maximumArea = 0;
        for(int i = 0, j = heights.length - 1; i < j; ){
            int area = Math.min(heights[i], heights[j]) * (j-i);

            if(area > maximumArea){
                maximumArea = area;
            }

            if(heights[i] < heights[j]){
                i++;
            }else{
                j--;
            }
        }

        return maximumArea;
    }
}
