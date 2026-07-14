class Solution {
    HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> check = new HashSet<>();
    ArrayList<Integer> res = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
         for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] preq: prerequisites){
            preMap.get(preq[0]).add(preq[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(dfs(i).size() == 0){
                return new int[0];
            }
        }

        // for(int i = 0; i < res.size(); i++){
        //     ans[i] = res.get(i);
        // }

        // return ans;

        int[] primitiveArray = res.stream()
                                .mapToInt(Integer::intValue)
                                .toArray();

        return primitiveArray;
    }

     public ArrayList<Integer> dfs(int course){
        if(visiting.contains(course)){
            return new ArrayList<>();
        }

        if(preMap.get(course).isEmpty()){
            if(!check.contains(course)){
                check.add(course);
                res.add(course);
            }
            return res;
        }

        visiting.add(course);
        for(int preq: preMap.get(course)){
            if(dfs(preq).size() == 0){
                return new ArrayList<>();
            }
        }

        visiting.remove(course);
        preMap.put(course, new ArrayList<>());
        check.add(course);
        res.add(course);
        return res;
    }
}
