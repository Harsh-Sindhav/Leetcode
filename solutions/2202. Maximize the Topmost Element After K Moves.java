class Solution {
    public int maximumTop(int[] nums, int k) {
         if (nums.length == 1 && k % 2 == 1) {
            return -1;
        }
        
        if (k == 0) {
            return nums[0];
        }
        
        if (k == 1) {
            return nums[1];
        }
     PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        if (nums.length > k) {
            int polled;
            for (int i = 0; i < k - 1; i++) {
                pq.add(nums[i]);
            } 
            
            polled = pq.poll();
            return Math.max(polled, nums[k]);
        } else {
            int polled;
            for (int i = 0; i < k - 1 && i < nums.length; i++) {
                pq.add(nums[i]);
            } 
            polled = pq.poll();
            return polled;
        }
        
    }
}
