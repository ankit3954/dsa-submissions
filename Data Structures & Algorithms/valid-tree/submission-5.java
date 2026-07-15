class Solution {
    HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1 || edges.length < n-1){
            return false;
        }


        for(int i = 0; i < n; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] preq: edges){
            if(preq[0] <= preq[1]){
                preMap.get(preq[0]).add(preq[1]);
            }else{
                preMap.get(preq[1]).add(preq[0]);
            }
            
        }

        if(!dfs(0) || visiting.size() < n-1){
            return false;
        }

        return true;
    }

    public boolean dfs(int course){
        if(visiting.contains(course)){
            return false;
        }

        if(preMap.get(course).isEmpty()){
            visiting.add(course);
            return true;
        }

        visiting.add(course);
        for(int preq: preMap.get(course)){
            if(!dfs(preq)){
                return false;
            }
        }

        // visiting.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
