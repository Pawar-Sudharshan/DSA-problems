class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        int n = num.length();

        for (int i = 0; i <= n - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                String curr = "" + num.charAt(i) + num.charAt(i) + num.charAt(i);
                if (ans.equals("") || curr.compareTo(ans) > 0) {
                    ans = curr;
                }
            }
        }

        return ans;
    }
}