class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int maxCount = Integer.MIN_VALUE, res = -1, count = 0;
        for(int i = 0, j = 1; j < nums.length; i++, j++){
            if(nums[i] == nums[j]){
                count++;
                maxCount = Math.max(maxCount, count);
                res = nums[i];
            }else{
                count = 1;
                maxCount =  Math.max(maxCount, count);
            }
        }

        return res;
    }
}
