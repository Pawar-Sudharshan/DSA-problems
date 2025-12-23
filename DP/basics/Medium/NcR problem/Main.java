import java.io.*;
import java.util.*;

public class Main {
    final static int mod = 1000000007;
    final static int size = 2000;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc =new Scanner(System.in);
        int t =sc.nextInt();
        long[][] dp = new long[size+1][size +1];
        for(int i = 0;i <= size;i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        } 
        
        for(int k = 1; k<= size ;k++){
            for(int l = 1 ; l <= size;l++){
                dp[k][l] = (dp[k-1][l-1] + dp[k-1][l])%mod;
            }
        }
        while(t-->0){
            int n = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(dp[n][r]);
        }
    }
}