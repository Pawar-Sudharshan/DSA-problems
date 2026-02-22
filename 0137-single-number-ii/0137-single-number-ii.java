class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        // iterate over all 32 bit positions
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            int mask = 1 << i; // bitmask for i-th bit

            // count contributions of i-th bit
            for (int x : nums) {
                if ((x & mask) != 0) {
                    bitCount++;
                }
            }

            // if this bit's count is not a multiple of 3,
            // it belongs to the single number
            if (bitCount % 3 != 0) {
                ans |= mask; // set i-th bit in answer
            }
        }

        return ans;
    }
}
