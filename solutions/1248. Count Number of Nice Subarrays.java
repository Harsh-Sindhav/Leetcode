class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i=0,j=0;
        int oddcount = 0;
        int ans = 0;
        int count = 0;
        while(j<nums.length){
         if(nums[j] % 2 ==1){
             oddcount++;
             count = 0;
         }
            
            // if(oddcount == k){
                while(oddcount ==k){
                   if(nums[i++]%2==1) oddcount--;
                   count++;
                }
                ans+= count;
                
            // }
            j++;
            }
        
        return ans;
    }
}
