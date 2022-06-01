class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] path = new int[n];
        Arrays.fill(path,Integer.MAX_VALUE);
        path[src] = 0;
        for(int j=0;j<=k;j++){
             int[] curr = new int[n];
            for(int l = 0; l < n; l++)curr[l] = path[l];
            for(int i = 0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            if(path[u] == Integer.MAX_VALUE) continue;
            if(path[u]+wt < curr[v]){
                curr[v] = path[u]+wt;
                // if(v == dst) return path[v];
            }
                  
            }
            for(int l = 0; l < n; l++)path[l] = curr[l];
        }
            if(path[dst] != Integer.MAX_VALUE) return path[dst];
            return -1;
    }
}
