class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if(s.length() == 0) return true;
        search : for(int i = 0;i<s.length();i++){
        for(int j = 0;j<goal.length();j++){
            if(s.charAt((i+j) % s.length()) != goal.charAt(j)) continue search;
        }    
            return true;
        }
        
        return false;
    }
}
