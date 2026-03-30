class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = 0, j = numbers.length-1; i < j; ){
            if(numbers[i] + numbers[j] > target){
                j--;
                continue;
            }else if(numbers[i] + numbers[j] < target){
                i++;
                continue;
            }else{
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;
    }
}
