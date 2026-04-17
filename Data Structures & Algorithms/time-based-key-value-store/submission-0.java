class TimeMap {

    HashMap<String, List<Pair<String, Integer>>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)){
            hm.put(key, new ArrayList<>());
        }
            
        hm.get(key).add(new Pair(value, timestamp));
    
    }
    
    public String get(String key, int timestamp) {
        
        List<Pair<String, Integer>> values = hm.getOrDefault(key, new ArrayList<>());
        System.out.println(values);
        int left = 0, right = values.size() - 1;
        String res = "";

        while(left <= right){
            int mid = left + (right - left)/2;

            if(values.get(mid).getValue() == timestamp){
                return values.get(mid).getKey();
            }else if(values.get(mid).getValue() < timestamp){
                res = values.get(mid).getKey();
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }

        return res;

    }

    private static class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
