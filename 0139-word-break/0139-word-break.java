class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       Set<String> words = new HashSet<>(wordDict);
       int n = s.length();
       int[][] dp = new int[n+1][n+1];
       for(int[] d :dp ) Arrays.fill(d,-1);
       return f(s,words,0,0,dp) == 1;
    }
    private static int f(String s , Set<String> words , int prev , int curr,int[][] dp){
        if(curr == s.length()) return 0;
        if(s.length()-1 == curr && words.contains(s.substring(prev,curr+1))) return dp[prev][curr]=1;
        if(dp[prev][curr] != -1) return dp[prev][curr];
        int has = 0;
        if(words.contains(s.substring(prev,curr+1))){
            has = f(s,words,curr+1,curr+1,dp);
        }
        int not = f(s,words,prev,curr+1,dp);
        return dp[prev][curr] = (has|not);

    }
}