class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            int target = -nums[i];
            for(int j = i+1, k = nums.length-1; j < k; ){
                 List<Integer> temp = new ArrayList<>();
                if(nums[j] + nums[k] == target){
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

            // if(sum > 0){
            //     j--;
            // }else if(sum < 0){
            //     i++;
            // }else{
            //     i++;
            //     j--;
            // }
        }

        return res.stream().distinct().collect(Collectors.toList());
    }
}
