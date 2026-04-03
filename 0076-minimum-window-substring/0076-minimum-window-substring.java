class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        String ans = "";
        int[] window = new int[128];
        int[] patt = new int[128];
        int left = 0;
        int n = s.length();

        for (char ch : t.toCharArray()) patt[ch]++;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            window[ch]++;

            while (isValid(window, patt)) {
                if (ans.length() == 0 || right - left + 1 < ans.length()) {
                    ans = s.substring(left, right + 1);
                }
                window[s.charAt(left)]--;
                left++;
            }
        }

        return ans;
    }

    static boolean isValid(int[] w, int[] patt) {
        for (int i = 0; i < 128; i++) {
            if (w[i] < patt[i]) return false;
        }
        return true;
    }
}