class Solution {
    public long maximumImportance(int n, int[][] roads) {
    
        int[] degree = new int[n];
        for(int i = 0;i<roads.length;i++){
              degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }
        
        Arrays.sort(degree);
        long ans = 0;
         
        for(int i = 0;i<n;i++){
            ans += (long)degree[i] * (i+1);
        }
        
        return ans;
    }
  
}
