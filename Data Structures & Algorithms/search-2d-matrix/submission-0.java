class Solution {
    public boolean binarySearch(int i, int j, int[][] matrix, int target){
        int left = 0;
        int right = j;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(matrix[i][mid] == target){
                return true;
            }else if(matrix[i][mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int j = matrix[i].length - 1;
            if(target <= matrix[i][j]){
                return binarySearch(i, j, matrix, target);
            }
        }

        return false;
    }
}
