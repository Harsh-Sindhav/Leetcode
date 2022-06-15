class Solution {
    public int longestStrChain(String[] words) {
//          Map<String, Integer> dp = new HashMap<>();
//         Arrays.sort(words, (a, b)->a.length() - b.length());
//         int res = 0;
//         for (String word : words) {
//             int best = 0;
//             for (int i = 0; i < word.length(); ++i) {
//                 String prev = word.substring(0, i) + word.substring(i + 1);
//                 best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
//             }
//             dp.put(word, best);
//             res = Math.max(res, best);
//         }
       
//         return res;
        
        HashMap<String,Integer> dp = new HashMap();
        HashSet<String> set = new HashSet();
        Collections.addAll(set,words);
        int ans = 0;
        for(String word : set){
           ans = Math.max(ans,dfs(word,dp,set));
        }
        return ans;
    }
    
    int dfs(String word, HashMap<String,Integer> dp, HashSet<String> set){
        if(dp.containsKey(word)) return dp.get(word);
        int ans = 1;
        StringBuilder sb = new StringBuilder(word);
        for(int i = 0;i<word.length();i++){
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if(set.contains(newWord)){
                int currans = 1 + dfs(newWord,dp,set);
                  ans = Math.max(ans,currans);
            }
            sb.insert(i,word.charAt(i));
        }
        dp.put(word,ans);
        return ans;
    }
    
}
