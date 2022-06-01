class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<pair> pq = new PriorityQueue();
        pq.add(new pair(0,0,grid[0][0]));
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            pair rem = pq.remove();
            vis[rem.row][rem.col] = true;
            for(int i = 0;i<4;i++){
                int rowdash = rem.row + dirs[i][0];
                int coldash = rem.col + dirs[i][1];
                if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length) continue;
                if(vis[rowdash][coldash]) continue;
                if(rowdash == n-1 && coldash == n-1){
                    return  Math.max(grid[n-1][n-1],rem.msf);
                }
                pq.add(new pair(rowdash,coldash,Math.max(rem.msf,grid[rowdash][coldash])));
            }
            
            
        }
        return 0;
        
    }
    
    class pair implements Comparable<pair>{
        int row;
        int col;
        int msf;
        pair(int row,int col,int msf){
            this.row = row;
            this.col = col;
            this.msf = msf;
        }
        public int compareTo(pair o){
           return this.msf - o.msf;
        }
    }
    
}
