class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] ans = new int [queries.length];
        int[] c1 = new int[queries.length] , c2 = new int[words.length];
        
        for(int i = 0;i<c1.length;i++){
            c1[i] = f(queries[i]);
        }
        
         for(int i = 0;i<c2.length;i++){
            c2[i] = f(words[i]);
        }
        
        Arrays.sort(c2);
        
        for(int i = 0;i<c1.length;i++){
            
            int l = 0,h = c2.length-1;
            // int mid = (h+l)/2;
            while(l <= h){
                 int mid = (h+l)/2;
            if(c2[mid] <= c1[i]){
                l = mid+1;
            }else{
                h = mid-1;
            }
            ans[i] = c2.length-l;
                
                }
        }
        
        // for (int i = 0; i < c1.length; i++) {
        //     int l = 0, r = c2.length - 1;
        //     while (l <= r) {
        //         int mid = (l + r) / 2;
        //         if (c2[mid] <= c1[i]) {
        //             l = mid + 1;
        //         }
        //         else {
        //             r = mid - 1;
        //         }
        //     }
        //     ans[i] = c2.length - l;
        // }
        
        return ans;
    }
    
    int f(String s){
        
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
