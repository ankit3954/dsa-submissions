class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i = 0; i < n+1; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            if(!union(u, v, parent)){
                return edge;
            }
        }

        return new int[0];
    }

    public boolean union(int u, int v, int[] parent){
        int rootU = find(u, parent);
        int rootV = find(v, parent);

        if(rootU == rootV){
            return false;
        }

        parent[rootU] = rootV;
        return true;
    }

    public int find(int node, int[] parent){
        if(parent[node] == node){
            return node;
        }

        parent[node] = find(parent[node], parent);
        return parent[node];
    }
}
