class Solution {
    public int[] searchRange(int[] nums, int target) {
       int ans[] = new int[2];
       ans[0] = leftbs(nums,target);
        ans[1] = rightbs(nums,target);
        return ans;
    }
    
    int leftbs(int[] nums,int target){
        int i = -1;
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(target <= nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
            if(nums[mid] == target) i = mid;
        }
        return i;
    }
    
     int rightbs(int[] nums,int target){
        int i = -1;
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(target >= nums[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
            if(nums[mid] == target) i = mid;
        }
        return i;
    }
    
}
