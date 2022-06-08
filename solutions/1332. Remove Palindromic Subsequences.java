class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        return s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2;
    }
}
