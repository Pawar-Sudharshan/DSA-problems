class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
          int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);

            if ((n & (n - 1)) == 0) {
                ans[i] = -1;
                continue;
            }

            int k = 0;
            int temp = n;
            while ((temp & 1) == 1) {
                k++;
                temp >>= 1;
            }

            ans[i] = n - (1 << (k - 1));
        }
        return ans;
    }
}