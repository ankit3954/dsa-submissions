class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            for(int j = i+1, k = nums.length-1; j < k; ){
                 List<Integer> temp = new ArrayList<>();
                if(nums[j] + nums[k] == target){
                    while (j < k && nums[j] == nums[j + 1]) j++; // Skip duplicate j
                    while (j < k && nums[k] == nums[k - 1]) k--; // Skip duplicate k
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                }else if(nums[j] + nums[k] < target){
                    j++;
                }else{
                    k--;
                }
            }
        }

        return res;
    }
}
