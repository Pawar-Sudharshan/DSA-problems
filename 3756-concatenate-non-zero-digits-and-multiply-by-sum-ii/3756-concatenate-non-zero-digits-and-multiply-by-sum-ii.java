class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        final int MOD = 1_000_000_007;

        // Precompute powers of 10 modulo MOD for O(1) query lookups
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix arrays
        long[] prefSum = new long[n];
        long[] prefX = new long[n];
        int[] prefCount = new int[n];

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            long prevSum = (i == 0) ? 0 : prefSum[i - 1];
            long prevX = (i == 0) ? 0 : prefX[i - 1];
            int prevCnt = (i == 0) ? 0 : prefCount[i - 1];

            prefSum[i] = prevSum + digit;

            if (digit != 0) {
                prefX[i] = (prevX * 10 + digit) % MOD;
                prefCount[i] = prevCnt + 1;
            } else {
                prefX[i] = prevX;
                prefCount[i] = prevCnt;
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            // 1. Calculate sum of digits in s[l..r]
            long sumDigits = prefSum[r] - (l == 0 ? 0 : prefSum[l - 1]);

            // 2. Count non-zero digits in s[l..r]
            int cnt = prefCount[r] - (l == 0 ? 0 : prefCount[l - 1]);

            // 3. Extract integer x formed by non-zero digits modulo MOD
            long prevX = (l == 0) ? 0 : prefX[l - 1];
            long x = (prefX[r] - (prevX * pow10[cnt]) % MOD + MOD) % MOD;

            // 4. Calculate answer
            long res = (x * (sumDigits % MOD)) % MOD;
            ans[i] = (int) res;
        }

        return ans;
    }
}