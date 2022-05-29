class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        for(int i=0;i<words.length-1;i++){
            for(int j = i+1;j<words.length;j++){
                if(noCommonLetters(words[i],words[j])){
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
     }
    
    boolean noCommonLetters(String s,String t){
    
        for(char ch : s.toCharArray()){
            if(t.indexOf(ch) != -1) return false;
        }
        return true;
    }
    
}
