class Solution {
    static int ans;

    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;

        for (int x : weights) {
            l = Math.max(l, x);
            r += x;
        }

        ans = Integer.MAX_VALUE;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (valid(weights, m, days)) {
                ans = Math.min(ans, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }

    private static boolean valid(int[] w, int m, int d) {
        int cnt = 1;
        int sum = 0;

        for (int x : w) {
            if (sum + x > m) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }

        return cnt <= d;
    }
}