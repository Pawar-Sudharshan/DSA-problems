class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return f(s,0,dp);
    }
    private static int f(String s , int idx,int[] dp){
        if(s.length() == idx) return 1;
        int x = s.charAt(idx) -'0';
        if(x<=0 ) return 0;
        if(dp[idx] != -1) return dp[idx];
        int one = f(s,idx+1,dp);
        int y = 0;
        if(idx+1 < s.length()){
            int k= Integer.parseInt(s.substring(idx,idx+2)) ;
            if(k > 0 && k <= 26)
                y = f(s,idx+2,dp);
        }
        return  dp[idx] = one+y; 

    }
}