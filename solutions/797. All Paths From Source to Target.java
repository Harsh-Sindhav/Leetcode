class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> path = new ArrayList();
        path.add(0);
        dfs(graph,path,ans,0);
        return ans;
    }
    
    void dfs(int[][] graph,List<Integer> path,List<List<Integer>> ans,int src){
        if(src == graph.length-1){
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int node : graph[src]){
            path.add(node);
            dfs(graph,path,ans,node);
                path.remove(path.size()-1);
        }
    }
}
