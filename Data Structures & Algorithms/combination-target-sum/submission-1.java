class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int sum = 0;
        combinationSumHelper(nums, target, sum);

        return ans;
    }

    public void combinationSumHelper(int[] nums, int target, int sum) {
        if(sum > target) return;

        if(sum == target){
            ans.add(new ArrayList<>(combination));
            return;
        }


        for(int i = 0; i < nums.length; i++){
            if(combination.size() > 0 && combination.getLast() > nums[i]){
                continue;
            }
            combination.add(nums[i]);
            combinationSumHelper(nums, target, sum + nums[i]);
            combination.removeLast();
        }

    }

}
