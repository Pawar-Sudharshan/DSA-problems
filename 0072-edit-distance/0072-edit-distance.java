class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int a[] : dp) Arrays.fill(a,-1);
        return f(word1,word2,0,0 ,dp);
    }
    private static int f(String a , String b , int i , int j , int[][] dp){
        if(i == a.length() && j == b.length()) return 0;
        if(i == a.length()) return b.length() - j;
        if(j == b.length()) return a.length()-i;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j]= f(a,b,i+1,j+1,dp);
        int delete = f(a,b,i+1,j,dp);
        int replace = f(a,b,i+1,j+1,dp);
        int add = f(a,b,i,j+1,dp);
        return dp[i][j] = 1+Math.min(delete,Math.min(add,replace)); 
    }
}