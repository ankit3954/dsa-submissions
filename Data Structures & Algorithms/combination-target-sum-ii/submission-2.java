class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, 0);
        return ans;
    }

    public void combinationSumHelper(int[] nums, int target, int sum, int i) {
        if(sum == target){
            ans.add(new ArrayList<>(combination));
            return;
        }
        
        if(i >= nums.length || sum > target) return;


        combination.add(nums[i]);
        combinationSumHelper(nums, target, sum + nums[i], i+1);
        combination.removeLast();
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        combinationSumHelper(nums, target, sum, i+1);

    }
}
