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

        int left = 0;
        int right = matrix.length - 1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left)/2;
            int j = matrix[0].length - 1;
            if(matrix[mid][j] == target){
                return true;
            }else if(target >= matrix[mid][0] && target <=  matrix[mid][j]){
                return binarySearch(mid, matrix, target);
            }else if(target > matrix[mid][j]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        // return binarySearch(mid, matrix, target);
        // for(int i = 0; i < matrix.length; i++){
        //     int j = matrix[i].length - 1;
        //     if(target <= matrix[i][j]){
        //         return binarySearch(i, j, matrix, target);
        //     }
        // }

        return false;
    }
}
