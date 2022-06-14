class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        if(word1.length() < word2.length()) minDistance(word2,word1);
          dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
       return helper(word1,word2,0,0);  
    }
    
    int helper(String word1, String word2,int i,int j){
         if(word1.length() == i){
            return word2.length()-j;
        }
          if(word2.length() == j){
            return word1.length()-i;
        }
           
            if(dp[i][j] != -1) return dp[i][j];
        
              int count = 0;
           if(dp[i][j] == -1){
             if(word1.charAt(i) == word2.charAt(j)){
                 count = helper(word1,word2,i+1,j+1);
             }else{
                 count += 1 + Math.min(helper(word1,word2,i,j+1),helper(word1,word2,i+1,j));
             }
               dp[i][j] = count;
           }else{
               count = dp[i][j];
           }
                                 
        return count;
    }
    
}
