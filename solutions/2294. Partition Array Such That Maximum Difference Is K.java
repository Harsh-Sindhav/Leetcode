class Solution {
    public int partitionArray(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int l = i,h = nums.length-1;
            int res = nums.length-1;
            while(l<=h){
                int mid = l + (h-l)/2;
                if(nums[mid]-nums[i] <= k){
                    l = mid+1;
                    res = mid;
                    
                }else{
                    h = mid-1;
                }
            }
            i = res;
            count++;
        }
        
        
        
        return count;
    }
}
