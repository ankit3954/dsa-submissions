class Solution {
    public boolean binarySearch(int i, int[][] matrix, int target){
        int left = 0;
        int right = matrix[0].length - 1;

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

        int top = 0;
        int bottom = matrix.length - 1;
        int mid = 0;
        while(top <= bottom){
            mid = top + (bottom - top)/2;
            int j = matrix[0].length - 1;
            if(matrix[mid][j] == target){
                return true;
            }else if(target >= matrix[mid][0] && target <=  matrix[mid][j]){
                return binarySearch(mid, matrix, target);
            }else if(target > matrix[mid][j]){
                top = mid + 1;
            }else{
                bottom = mid - 1;
            }
        }

        return false;
    }
}
