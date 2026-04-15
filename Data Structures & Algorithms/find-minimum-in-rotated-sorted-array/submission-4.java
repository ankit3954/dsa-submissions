class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minElem = Integer.MAX_VALUE;

        while(left <= right){

            if(nums[left] < nums[right]){
               minElem = Math.min(minElem, nums[left]);
               break;
            }

            int mid = left + (right - left)/2;
            minElem = Math.min(minElem, nums[mid]);

            if(nums[mid] >= nums[left]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return minElem;
    }
}
