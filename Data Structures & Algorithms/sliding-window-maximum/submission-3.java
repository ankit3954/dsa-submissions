class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0, i = 0;
        int[] res = new int[nums.length - k + 1];
        while(r < nums.length){
            while(!q.isEmpty() && (nums[q.peekLast()] < nums[r])){
                q.removeLast();
            }
            q.add(r);

            if(l > q.peek()){
                q.pop();
            }

            if((r + 1) >= k){
                res[i] = nums[q.peekFirst()];
                i++;
                l++;
            }

            r++;
        }
        return res;
    }
}
