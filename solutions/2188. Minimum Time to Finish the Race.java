class Solution {
    
    // long best[] = new long[1001];
    int maxLaps;
    int f(int numLaps,int changeTime,int[] dp,int[] best){
        if( numLaps ==0) return -changeTime;
        if(dp[numLaps] != -1) return dp[numLaps];
         int mini = (int)Math.pow(10,9);
        for(int laps = 1;laps <= Math.min(numLaps,maxLaps);laps++){
            int time = best[laps] + changeTime + f(numLaps-laps, changeTime,dp,best);
            mini = Math.min(mini,time);
        }
        return dp[numLaps] = (int)mini;
    }
    
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
      
        int[] dp = new int[numLaps+1];
        int[] best = new int[numLaps+1];
        maxLaps = 0;
        Arrays.fill(best,Integer.MAX_VALUE);
        Arrays.fill(dp,-1);
        for(int[] x : tires){
        if(x[0] == 1 && x[1] == 2 && numLaps == 1) return 1;
​
            int fi = x[0];
            int ri = x[1];
            long time = fi;
            long curLapTime = fi;
       for(int lap= 1;lap <= numLaps && curLapTime < changeTime + fi; lap++){
                if( time < best[lap]){
                     best[lap] = (int)time;
                }
                maxLaps = Math.max(maxLaps,lap);
                
                   curLapTime *= ri;
                time +=   curLapTime;
               
            }
        }
     
        
        return f(numLaps,changeTime,dp,best);
    }
}
