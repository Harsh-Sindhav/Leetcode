class Solution {
    public int maxScore(int[] arr, int k) {
      int n = arr.length;
      k = Math.min(k,n);
       
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum += arr[i];
        }
        int maxSum = sum;
        int i = 0;
        while(i < k){
            sum = sum-arr[k-i-1] + arr[n-i-1];
            maxSum = Math.max(sum,maxSum);
            i++;
        }
        return maxSum;
    }
}
