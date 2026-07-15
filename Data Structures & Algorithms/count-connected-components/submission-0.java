class Solution {
    HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] preq: edges){
            preMap.get(preq[0]).add(preq[1]);
            preMap.get(preq[1]).add(preq[0]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(visiting.contains(i)){
                continue;
            }
            ans++;
            dfs(i, -1);
        }

        return ans;
    }

      public void dfs(int node, int prevNode){
        if(visiting.contains(node)){
            return;
        }

        visiting.add(node);
        for(int preq: preMap.get(node)){
            if(preq == prevNode){
                continue;
            }

            dfs(preq, node);
        }
        return;
    }
}
