class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int i = 0;i<n;i++){
            graph.add(i,new ArrayList());
        }
        
        for(int i = 0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            // if(u == v) return false;
            graph.get(u).add(v);
        }
        
        return helper(n,graph);
    }
    
    boolean helper(int n,ArrayList<ArrayList<Integer>> graph){
        int[] indegree = new int[n];
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            for(int nbrs : graph.get(i)){
                indegree[nbrs]++;
            }
        }
        int count = 0;
        
        Queue<Integer> q = new LinkedList();
        for(int i = 0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
               ans[count++] = i;
            }
        }
        
        while(!q.isEmpty()){
            int rem = q.remove();
            for(int nbrs : graph.get(rem)){
                indegree[nbrs]--;
                if(indegree[nbrs] == 0){
                    q.add(nbrs);
                ans[count++] = nbrs;}
            }
        }
        
        if(count == n) return true;
        else return false;
        
    }
}
