class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinationSumHelper(nums, target, 0, 0);
        return ans;
    }

    public void combinationSumHelper(int[] nums, int target, int sum, int i) {
        if(i >= nums.length || sum > target) return;

        if(sum == target){
            ans.add(new ArrayList<>(combination));
            return;
        }

        combination.add(nums[i]);
        combinationSumHelper(nums, target, sum + nums[i], i);
        combination.removeLast();
        combinationSumHelper(nums, target, sum, i+1);

    }
}
