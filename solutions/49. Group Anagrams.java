class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List> map = new HashMap();
        for(String s : strs){
            char[] x = s.toCharArray();
            Arrays.sort(x);
            String ca = String.valueOf(x);
            if(!map.containsKey(ca)) map.put(ca,new ArrayList());
            map.get(ca).add(s);
        }
        
        return new ArrayList(map.values());
    }
}
