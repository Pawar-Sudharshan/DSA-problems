class Solution {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        int pos = 0; // 0 -> even index, 1 -> odd index

        while (n > 0) {
            int bit = n & 1;      // current least significant bit
            if (bit == 1) {
                if (pos == 0) even++;
                else odd++;
            }
            n >>= 1;              // move to next bit
            pos ^= 1;             // toggle between 0 and 1
        }

        return new int[]{even, odd};
    }
}
