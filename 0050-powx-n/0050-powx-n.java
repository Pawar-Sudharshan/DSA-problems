class Solution {
    public double myPow(double x, int n) {
        // Handle edge case: if n is Integer.MIN_VALUE, convert to long to avoid overflow
        long N = n;
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }
        
        // Recursive case using exponentiation by squaring
        double half = fastPow(x, n / 2);
        
        if (n % 2 == 0) {
            // If n is even: x^n = (x^(n/2))^2
            return half * half;
        } else {
            // If n is odd: x^n = x * (x^(n/2))^2
            return half * half * x;
        }
    }
}