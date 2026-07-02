class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        
        while (a >= b) {
            long tempB = b;
            int shifts = 0;
            while (a >= (tempB << 1)) {
                tempB <<= 1;
                shifts++;
            }
            a -= tempB;
            result += (1 << shifts);
        }
        
        return (dividend < 0) ^ (divisor < 0) ? -result : result;
    }
}