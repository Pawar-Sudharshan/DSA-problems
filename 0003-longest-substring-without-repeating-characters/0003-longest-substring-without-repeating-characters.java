class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                char curr = s.charAt(left);
                set.remove(curr);
                left++;
            }
            set.add(ch); 
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
