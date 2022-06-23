class Solution {
    public int coinChange(int[] coins, int amount) {
        // if(coins.length == 1) 
        //     if(amount < coins[0]){
        //         if(amount == 0) return 0;
        //         else return -1;
        //     }
        // else if(amount % coins[0] == 0) return amount/coins[0];
        // else return -1;
        
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][0] = 0;
                dp[0][j] = Integer.MAX_VALUE-1;
            }
        }
        
            for(int j = 1;j<dp[0].length;j++){
                // dp[i][0] = 0;
                // dp[0][j] = Integer.MAX_VALUE-1;
                if(j % coins[0] == 0){
                    dp[1][j] = j/coins[0];
                }else{
                    dp[1][j] = Integer.MAX_VALUE-1;
                }
            }
        
           for(int i = 2;i<dp.length;i++){
               for(int j =1;j<dp[0].length;j++){
                   if(coins[i-1] <= j){
                       dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                   }else{
                       dp[i][j] = dp[i-1][j];
                   } 
               }
           }
        
        return dp[coins.length][amount] == Integer.MAX_VALUE-1 ? -1 : dp[coins.length][amount];
    }
}
