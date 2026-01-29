class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];

        int iPos = 0, iNeg = 0;
        for (int x : nums) {
            if (x > 0) {
                pos[iPos++] = x;
            } else {
                neg[iNeg++] = x;
            }
        }

        int[] ans = new int[n];
        int p = 0, q = 0, k = 0;
        while (p < pos.length && q < neg.length) {
            ans[k++] = pos[p++]; // positive
            ans[k++] = neg[q++]; // negative
        }

        return ans;
    }
}
