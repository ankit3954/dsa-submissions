class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> heightSt = new Stack<>();
        Stack<Integer> indexSt = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!heightSt.isEmpty() && (heights[i] < heightSt.peek())){
                start = indexSt.pop();
                int area = (i - start) * heightSt.pop();
                maxArea = Math.max(maxArea, area);
            }

            heightSt.push(heights[i]);
            indexSt.push(start);
        }

        while(!heightSt.isEmpty() && !indexSt.isEmpty()){
            int area = (heights.length - indexSt.pop()) * heightSt.pop();
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
