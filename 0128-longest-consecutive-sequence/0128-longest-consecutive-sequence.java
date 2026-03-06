class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int ans = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int cnt = 1;          
                int curr = x;
                while (set.contains(curr + 1)) {
                    curr++;
                    cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
