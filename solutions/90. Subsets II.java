class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        backtrack(nums,ans,new ArrayList(),0);
        return ans;
    }
    
    void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> temp,int start){
        
        ans.add(new ArrayList(temp));
        
        for(int i = start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue;
         temp.add(nums[i]);
            backtrack(nums,ans,temp,i+1);
            temp.remove(temp.size()-1);
        }
        
    }
    
}
