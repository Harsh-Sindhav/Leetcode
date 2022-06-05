class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
 
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            map.put(nums[i], i);
        }
        
        for(int[] op: operations){
            int idx = map.get(op[0]);
            nums[idx] = op[1];
            map.remove(op[0]);
            map.put(op[1], idx);
        }
        
        return nums;
    }
}
