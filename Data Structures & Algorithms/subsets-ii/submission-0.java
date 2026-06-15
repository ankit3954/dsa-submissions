class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetHelper(nums, 0);
        return ans;
    }

    public void subsetHelper(int[] nums, int i) {
        if(i == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        subsetHelper(nums, i+1);

        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }

        subset.removeLast();
        subsetHelper(nums, i+1);
    }
}
