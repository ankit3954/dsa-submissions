class Solution {
    HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] preq: prerequisites){
            preMap.get(preq[0]).add(preq[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course){
        if(visiting.contains(course)){
            return false;
        }

        if(preMap.get(course).isEmpty()){
            return true;
        }

        visiting.add(course);
        for(int preq: preMap.get(course)){
            if(!dfs(preq)){
                return false;
            }
        }

        visiting.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
