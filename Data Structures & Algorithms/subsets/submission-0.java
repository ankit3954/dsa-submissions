class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subSets = new ArrayList<>();
        subsetsHelper(nums, 0, subSets);

        return ans;
    }

    public void subsetsHelper(int[] nums, int i, List<Integer> subSets) {
        if(i == nums.length){
            List<Integer> res = new ArrayList<>();
            for(int j = 0; j < subSets.size(); j++){
            res.add(subSets.get(j));
            
        }
            ans.add(res);
            return;
        }

        subSets.add(nums[i]);
        subsetsHelper(nums, i+1, subSets);

        subSets.removeLast();
        subsetsHelper(nums, i+1, subSets);
    }
}
