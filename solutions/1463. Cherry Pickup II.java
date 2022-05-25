class Solution {
    
    int f(int i,int j1,int j2,int r,int c,int[][] grid,int[][][] dp){
      if(j1 < 0 || j2 < 0  || j1 >=c || j2 >=c){
          return Integer.MIN_VALUE;
      }
     
        if(i == r-1)
            if(j1 == j2) return grid[i][j1];
        else return grid[i][j1] + grid[i][j2];
        
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int maxi = Integer.MIN_VALUE;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int value = 0;
                if(j1 == j2) 
                    value = grid[i][j1];
                else {
                    value += grid[i][j1]+grid[i][j2];
                    value += f(i+1,j1+dj1,j2+dj2,r,c,grid,dp);
                    
                }
                maxi = Math.max(maxi,value);
            }
        }
        
        return dp[i][j1][j2] = maxi;
    }
    
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        int x,y,z;
//         for(x = 0; x< r; x++) {
// for(y = 0; y< c; y++) {
// for(z = 0; z< c; z++) {
//    dp[x][y][z] = -1; 
// }
// }
// }
        // return f(0,0,c-1,r,c,grid,dp);
    
        for(int j1=0;j1<m;j1++){
            for(int j2 = 0;j2<m;j2++){
                if(j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
                
            }
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j1 = 0;j1<m;j1++){
                for(int j2 = 0;j2<m;j2++){
                    int maxi = Integer.MIN_VALUE;
                    for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int value = 0;
                if(j1 == j2) 
