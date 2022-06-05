class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        while(nums.length > 1){
            int[] num = new int[nums.length/2];
            for(int i=0;i<nums.length/2;i++){
                if(i%2==0)
                    num[i]= Math.min(nums[2*i],nums[2*i+1]);
            else
                num[i] = Math.max(nums[2*i],nums[2*i+1]);
            
        }
               nums = num;
        }
        return nums[0];
    }
}
