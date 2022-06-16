class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int len = 0;
        int st = 0,e = 0;
        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;j<dp.length;j++,i++){
                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                  if(dp[i][j]){
                len = g+1;
                st = i;
                e = j;
            }
            }
          
        }
        return s.substring(st,e+1);
    }
}
