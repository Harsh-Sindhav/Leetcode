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
    
     int bitmask1 = 0 ,bitmask2 = 0;
        
        for(char a : s.toCharArray())
            bitmask1 |= 1 << (a - 'a');
         for(char a : t.toCharArray())
            bitmask2 |= 1 << (a - 'a');
        
        
        return (bitmask1 & bitmask2)== 0;
    }
    
}
