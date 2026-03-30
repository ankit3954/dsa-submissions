class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequentMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!frequentMap.containsKey(nums[i])){
                frequentMap.put(nums[i], 1);
            }else{
                frequentMap.put(nums[i], frequentMap.get(nums[i]) + 1);
            }
        }

        List<Integer>[] freqArray = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry : frequentMap.entrySet()){
            int currentValue = entry.getValue();
            int currentKey = entry.getKey();
            
            if (freqArray[currentValue] == null) {
                freqArray[currentValue] = new ArrayList<>();
            }
            freqArray[currentValue].add(currentKey);
        }

        int[] res = new int[k];
        int index = 0;
        for(int j = freqArray.length - 1; j >= 0 && index < k; j--){
            if(freqArray[j] == null)
                continue;

            for (int val : freqArray[j]) {
                if (index < k) {
                    res[index] = val;
                    index++;
                }
            }
        }
        return res;
    }
}