class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map = new HashMap();
        for(String s : senders){
            map.put(s,0);
        }
          int max = 0;
        String ans = "";
        for(int i = 0;i<senders.length;i++){
            
            int count = countWords(messages[i]);
            int curmax = map.get(senders[i])+count;
            map.put(senders[i],map.get(senders[i])+count);
            if(curmax == max){
                if (senders[i].compareTo(ans) > 0){
                    ans = senders[i];
                }
            }else if(curmax > max){
                max = curmax;
                ans = senders[i];
            }
        }
        return ans;
    }
    
   int countWords(String str) {
    if(str.length()==0)return 0;
    int spaces = 0;
    for (int i = 0; i < str.length(); i++) {
        if(str.charAt(i)==' ')spaces++;
    }
    return spaces+1;
}
}
