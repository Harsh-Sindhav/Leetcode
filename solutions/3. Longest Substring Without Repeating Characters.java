class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() ==0 || s == null)return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 1;
        int i=0,j=0;
        while(j<s.length()){
         // if(map.containsKey(s.charAt(j))){
         //     map.put(s.charAt(j),map.get(s.charAt(j))+1);
         // }else{
         //     map.put(s.charAt(j),1);
         // }
            
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            
            if(map.size() == j-i+1){
                max = Math.max(max,j-i+1);
                
            }else if(map.size() < j-i+1){
                while(map.size() < j-i+1){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i)) == 0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                }
                }
                j++;
        }
        return max;
    }
}
