class Solution {
    public boolean digitCount(String num) {
        // char[] c = num.toCharArray();
        int[] freq = new int[10];
        for(int i = 0;i<num.length();i++){
            freq[num.charAt(i)-'0']++;
        }
        for(int i=0;i<num.length();i++){
            if(freq[i] != (num.charAt(i)-'0')) return false;
        }
        return true;
    }
}
