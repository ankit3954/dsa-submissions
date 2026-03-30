class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int[] resArr = new int[2];
        for(int i = 0; i < nums.length; i++){
            int keyNum = target-nums[i];
            if(!sumMap.containsKey(nums[i])){
                sumMap.put(keyNum, i);
            }else{
                int firstIndex = sumMap.get(nums[i]);
                resArr[0] = firstIndex;
                resArr[1] = i;
            }
        }

        return resArr;
    }
}
