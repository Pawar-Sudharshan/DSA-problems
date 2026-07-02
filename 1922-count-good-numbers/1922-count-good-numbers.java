class Solution {
    static final long MOD = (long)1e9 + 7;

    static long power(long a, long b) {
        long ans = 1;
        long base = a % MOD;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            b >>= 1;
        }
        return ans;
    }

    public int countGoodNumbers(long n) {
        long odd  = n / 2;             // odd indices
        long even = n / 2 + n % 2;     // even indices

        long res = (power(5, even) * power(4, odd)) % MOD;
        return (int) res;
    }
}