class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) return nums;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue((n1,n2) -> map.get(n1) - map.get(n2));
        
        for(int i : map.keySet()){
          
            pq.add(i);
              if(pq.size() > k) pq.poll();
        }
        
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
