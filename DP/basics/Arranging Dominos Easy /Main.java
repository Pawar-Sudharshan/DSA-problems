import java.io.*;
import java.util.*;

public class Main {
    static int mod = (int)1e9+7;
    // static int size = 10_000_000;
    static long dp[] ;

    // public static long solve(int n){
    //     if(n == 0) return 1;
    //     if(n == 1) return 1;
    //     if(n == 2) return 2;
    //     if(n == 3) return 3;
    //     if(n == 4) return 5;
    //     if((dp[n] != -1)) return dp[n];
    //     long ans = (2*solve(n-1))%mod;
    //     ans = (ans + 32*(solve(n-5)))%mod;
    //     dp[n] = ans;
    //     return ans;

    // }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc= new Scanner(System.in);
        int t =sc.nextInt();
        List<Integer> queries = new ArrayList<>();
        int max = 0;
        while(t-- >0){
            int x = sc.nextInt();
            max = Math.max(x,max);
            queries.add(x);
        }
         dp = new long[max+1];
        if(max >=0) dp[0] = 1;
        if(max >=1) dp[1] =1;
        if(max >=2) dp[2] =2;
         if(max >=3)dp[3] =3;
        if(max >=4) dp[4] =5;

         for(int i = 5 ;i <= max ;i++){
            dp[i] = (dp[i-1] + dp[i-2] + 8 * dp[i-5] )%mod;
         }
        // Arrays.fill(dp,-1);
        for(int n : queries)  System.out.println(dp[n]);
    }
}