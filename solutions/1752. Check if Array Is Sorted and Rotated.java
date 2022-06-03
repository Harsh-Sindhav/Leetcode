class Solution {
    public boolean check(int[] nums) {
        int c = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                c = i;
                break;
            }
        }
        if(c != 0 && nums[0] < nums[nums.length-1]) return false;
        if(c == nums.length-1 || c == 0) return true;
        
        for(int i = c+1 ;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }
        
        return  true;
    }
}
