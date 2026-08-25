class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int[] ans = new int[nums.length];
        int l = nums.length;

        ans[l-1] = nums[l-1];
        ans[l-2] = nums[l-2];

        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        if(ans[l-1] >= ans[l-2]){
            max = l-1;
            secondMax = l-2;
        }else{
            max = l-2;
            secondMax = l-1;
        }

        for(int i = l - 3; i >= 0; i--){
            int reqMax = i+1 == max ? secondMax : max;
            ans[i] = nums[i] + ans[reqMax];

            if(ans[i] >= ans[max]){
                int temp = max;
                max = i;
                secondMax = temp;
            }
        }

        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }

        return ans[max];

    }
}
