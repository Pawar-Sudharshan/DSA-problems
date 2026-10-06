class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] a : dp) Arrays.fill(a,-1);
        return f(text1,text2,n,m,0,0,dp);
    }

    private static int f(String a , String b , int n , int m , int i , int j,int[][] dp){
        if(i == n || j == m) return 0; 
        
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = 1 + f(a,b,n,m,i+1,j+1,dp);
        }
        
        return dp[i][j]= Math.max(f(a,b,n,m,i,j+1,dp) , f(a,b,n,m,i+1,j,dp));
    }
}