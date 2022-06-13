class Solution {
    public String minWindow(String s, String t) {
    if (t.length() > s.length())
    {
        return "";
    }
​
    if (s.equals(t))
        return s;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            int count= map.getOrDefault(t.charAt(i),0);
            map.put(t.charAt(i),count+1);
        }
        int count = map.size();
        int i=0,j=0;
        String ans = "";
        int min = Integer.MAX_VALUE;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) ==0) count--;
            }
          
             if(count ==0){
               if(min > j-i+1){
                   min = j-i+1;
                   ans = s.substring(i,j+1);
               }
                 
                 while(count == 0){
                     if(map.containsKey(s.charAt(i))){
                         if(map.get(s.charAt(i)) <= 0){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
                         if(map.get(s.charAt(i)) ==1 )
                      count++;
                     
                 }
                     }
                     i++;
                     if(j-i+1 < min && count ==0){
                         min = j-i+1;
                         ans = s.substring(i,j+1);
                     }
                 }
        
            }   
         j++;
        }
        
        
            
        
        
        return ans;
    }
}
