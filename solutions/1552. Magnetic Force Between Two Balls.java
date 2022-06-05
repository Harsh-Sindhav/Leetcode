class Solution {
    
    public boolean check(int m,int[] pos,int n,int dist){
        int count = 1;
        int last_pos = pos[0];
        for(int i=0;i<n;i++){
            if(pos[i] - last_pos >= dist){
                last_pos = pos[i];
                count++;
            }
            if(count ==m){
                return true;
            }
        }
        
        return false;
    }
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 0;
        int end = position[position.length-1] - position[0];
        int ans = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(check(m,position,position.length,mid)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
}
