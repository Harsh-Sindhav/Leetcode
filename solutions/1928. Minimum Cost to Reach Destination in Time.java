class Solution {
  class Pair implements Comparable<Pair>{
        int v;
        int time;
        int cost;
        public Pair(int v, int time, int cost){
            this.v = v;
            this.time = time;
            this.cost = cost;
        }
        
        public int compareTo(Pair o){
             return Integer.compare(this.cost, o.cost);
           
        }
    }
    public int minCost(int maxTime, int[][] edges, int[] fees) {
        int n = fees.length;
       
​
        boolean[][] vis = new boolean[n + 1][maxTime + 1];
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i< n; ++i){
            adj.add(new ArrayList<>());
           
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            adj.get(u).add(new int[]{v, t});
            adj.get(v).add(new int[]{u, t});
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0, fees[0]));
        while(pq.size() > 0){
            Pair rem = pq.poll();
            if(rem.time > maxTime) continue;
            if(rem.v == (n - 1)) return rem.cost;
            
            if(vis[rem.v][rem.time]) continue;
            vis[rem.v][rem.time] = true;
            for(int[] nbrs: adj.get(rem.v)){
                if(nbrs[1] + rem.time > maxTime) continue;
                if(vis[nbrs[0]][nbrs[1] + rem.time]) continue;
                pq.add(new Pair(nbrs[0],nbrs[1] + rem.time, rem.cost + fees[nbrs[0]]));
            }
        }
        
        return  -1; 
    }
}
