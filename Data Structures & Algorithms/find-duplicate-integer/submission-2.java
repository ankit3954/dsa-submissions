class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int res = -1;
        for(int i = 0, j = 1; j < nums.length; i++, j++){
            if(nums[i] == nums[j]){
                res = nums[i];
            }
        }

        return res;
    }
}
