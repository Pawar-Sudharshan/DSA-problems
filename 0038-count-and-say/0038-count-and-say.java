class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < result.length()) {
                char c = result.charAt(j);
                int count = 0;
                while (j < result.length() && result.charAt(j) == c) {
                    count++;
                    j++;
                }
                sb.append(count).append(c);
            }
            result = sb.toString();
        }
        return result;
    }
}