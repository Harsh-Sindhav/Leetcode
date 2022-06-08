class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, n = nums.length-1,j=0,sum = 0,size = Integer.MAX_VALUE;
        while(j <= n){
            
            if(sum < target) sum += nums[j];
            
               
                while(sum  >= target){
                     size = Math.min(j-i+1,size);
                    sum -= nums[i];
                    // if(sum >= target) size--;
                    i++;
                } 
            
            j++;
        }
        return size != Integer.MAX_VALUE ? size : 0;
    }
}
