class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        
        HashMap<Integer, Integer> consecutiveTracker = new HashMap<>();
        int longestConsecutive = 1;

        for(int i = 0; i < nums.length; i++){
            consecutiveTracker.put(nums[i], 0);
        }

        for(int j = 0; j < nums.length; j++){
            int nextElement = nums[j] + 1;
            int max = 1;
            if(consecutiveTracker.get(nums[j]) == 0){
                consecutiveTracker.put(nums[j], 1);
                while(consecutiveTracker.containsKey(nextElement)){
                    max++;
                    consecutiveTracker.put(nextElement, 1);
                    nextElement++;
                }
            }

            if(max > longestConsecutive){
                longestConsecutive = max;
            }
        }

        return longestConsecutive;
    }
}
