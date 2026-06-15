class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> permutation = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] pick = new boolean[nums.length];
        permuteHelper(nums, pick);
        return ans;    
    }

    public void permuteHelper(int[] nums, boolean[] pick) {
        if(permutation.size() == nums.length){
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!pick[i]){
                permutation.add(nums[i]);
                pick[i] = true;
                permuteHelper(nums, pick);
                permutation.removeLast();
                pick[i] = false;
            }
           
        }
    }
}
