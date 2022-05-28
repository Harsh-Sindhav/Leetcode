class Solution {
    public String longestCommonPrefix(String[] strs) {
        return lcp(strs,0,strs.length-1);
    }
    
    String lcp(String[] strs,int l,int r){
        if(l == r){
            return strs[l];
        }
        int mid = (l+r)/2;
        String lcpl = lcp(strs,l,mid);
        String lcpr = lcp(strs,mid+1,r);
        return commonPrefix(lcpl,lcpr);
    }
    
    String commonPrefix(String left,String right){
        int min = Math.min(left.length(),right.length());
        for(int i = 0;i<min;i++){
            if(left.charAt(i) != right.charAt(i)){
                return left.substring(0,i);
            }
        }
        return left.substring(0,min);
    }
}
