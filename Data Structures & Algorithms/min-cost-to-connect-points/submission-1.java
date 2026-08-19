class Edge{
    int source;
    int dest;
    int weight;
}

class Solution {

    public int findParent(int v, int[] parent){
        if(parent[v] == v){
            return v;
        }

        return findParent(parent[v], parent);
    }
    public int kruskal(Edge[] edges, int n, int e){
        Arrays.sort(edges, (a, b) -> Integer.compare(a.weight, b.weight));

        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        int count = 0;
        int i = 0;
        int minCost = 0;
        while(count != n-1){
            Edge currentEdge = edges[i];
            int sourceParent = findParent(currentEdge.source, parent);
            int destParent = findParent(currentEdge.dest, parent);

            if(sourceParent != destParent){
                count++;
                minCost += currentEdge.weight;
                parent[sourceParent] = destParent;
            }

            i++;
        }

        return minCost;
    }


    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int noOfEdges = (len * (len - 1))/2;
        Edge[] edges = new Edge[noOfEdges];

        int index = 0;
        for(int i = 0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                edges[index] = new Edge(); 
                edges[index].source = i;
                edges[index].dest = j;
        
                int xDiff = Math.abs(points[j][0] - points[i][0]);
                int yDiff = Math.abs(points[j][1] - points[i][1]);
                edges[index].weight = xDiff + yDiff;
                index++;
            }
        }

        return kruskal(edges, points.length, edges.length);
    }
}
