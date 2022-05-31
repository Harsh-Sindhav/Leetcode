class Solution {
    public int minDistance(String word1, String word2) {
        return editDistanceIdp(word1,word2);
    }
    
    int editDistanceIdp(String s1,String s2) {
      // top down
       int m = s1.length();
       int n= s2.length();
       int[][] dp = new int[m+1][n+1];
       for(int i=0;i<=m;i++) {
           dp[i][0]=i;
           }
           for(int j=0;j<=n;j++) {
               dp[0][j] = j;
           }
       for(int i=1;i<=m;i++) {
           for(int j=1;j<=n;j++) {
               if(s1.charAt(i-1) == s2.charAt(j-1)) {
                   dp[i][j] = dp[i-1][j-1];
               }else {
                   int remove,insert,substitute;
                    remove = dp[i-1][j];
                    insert =dp[i][j-1];
                    substitute = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(remove, Math.min(insert, substitute));  
               }
           }
       }
        // for(int i=0;i<dp.length;i++) {
        //  for(int j=0;j<dp[i].length;j++) {
        //      System.out.print(dp[i][j] + " ");
        //  }
        //  System.out.println();
        // }
     return dp[m][n];
       
   }
}
