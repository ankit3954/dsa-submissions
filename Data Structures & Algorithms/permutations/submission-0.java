class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> permutation = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permuteHelper(nums);
        return ans;    
    }

    public void permuteHelper(int[] nums) {
        if(permutation.size() == nums.length){
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(permutation.size() > 0 && permutation.contains(nums[i])){
                continue;
            }
            permutation.add(nums[i]);
            permuteHelper(nums);
            permutation.removeLast();
        }
    }
}
