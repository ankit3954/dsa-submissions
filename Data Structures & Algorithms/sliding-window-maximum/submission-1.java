class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1){
            return nums;
        }

        ArrayList<Integer> arr = new ArrayList<>();

        int l = 0;
        int r = k-1;
        int maxNum = 0;
        while(r - l < k && r < nums.length){
            maxNum = 0;
            for(int i = l; i <= r; i++){
                maxNum = Math.max(maxNum, nums[i]);
            }
            arr.add(maxNum);
            l++;
            r++;
        }

        int[] res = new int[arr.size()];
        for(int j = 0; j< res.length; j++){
            res[j] = arr.get(j);
        }

        return res;
    }
}
