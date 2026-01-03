class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007L;

        long twoColor = 6;   // ABA-type rows
        long threeColor = 6; // ABC-type rows

        for (int i = 2; i <= n; i++) {
            long nextTwo = (3 * twoColor + 2 * threeColor) % MOD;
            long nextThree = (2 * twoColor + 2 * threeColor) % MOD;

            twoColor = nextTwo;
            threeColor = nextThree;
        }

        return (int) ((twoColor + threeColor) % MOD);
    }
}
