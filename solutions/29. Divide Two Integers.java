class Solution {
    private static int HALF_INT_MIN = -1073741824;
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        int negatives = 2;
        if(divisor > 0){
            negatives--;
            divisor = -divisor;
        }
        
           if(dividend > 0){
            negatives--;
            dividend = -dividend;
        }
        
        int quotient =0;
        while(divisor >= dividend){
            int powerOfTwo = -1;
            int value = divisor;
            while(value >= HALF_INT_MIN && value + value >= dividend){
                value += value;
                powerOfTwo += powerOfTwo;
            }
            quotient += powerOfTwo;
            dividend -= value;
        }
        
        if(negatives != 1){
            return -quotient;
        }
        
        return quotient;
    }
}
