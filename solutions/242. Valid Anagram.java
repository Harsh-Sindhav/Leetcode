class Solution {
    public boolean isAnagram(String s, String t) {
//         char[] s1 = s.toCharArray();
//         char[] t1 = t.toCharArray();
//         Arrays.sort(s1);
//         Arrays.sort(t1);
     
//         return Arrays.equals(s1,t1);
         if(s.length() != t.length()) return false;
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        
        for(char c : map.keySet()){
            if(map.get(c) != 0) return false;
        }
        return true;
    }
}
