class Solution {
    HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        //if graph has less or more than n-1 edges it means that it is not tree 
        //edges > n-1 that means cycle
        // edges < n-1 that means disconnected graph
        if(edges.length > n-1 || edges.length < n-1){
            return false;
        }


        for(int i = 0; i < n; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] preq: edges){
            preMap.get(preq[0]).add(preq[1]);
            preMap.get(preq[1]).add(preq[0]);
        }

        if(!dfs(0, -1) || visiting.size() != n){
            return false;
        }

        return true;
    }

    public boolean dfs(int node, int prevNode){
        if(visiting.contains(node)){
            return false;
        }

        visiting.add(node);
        for(int preq: preMap.get(node)){
            if(preq == prevNode){
                continue;
            }

            if(!dfs(preq, node)){
                return false;
            }
        }
        return true;
    }
}
