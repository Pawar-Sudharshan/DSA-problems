import java.io.*;
import java.util.*;

public class Main {
    final static int mod = 1000000007;
    final static int size = 2000;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc =new Scanner(System.in);
        int t =sc.nextInt();
       
        while(t-->0){
            int n =sc.nextInt();
            int m =sc.nextInt();
            int A[][] =new int[n][m];
            for(int i = 0 ;i < n ;i++){
                for(int j = 0 ;j < m ;j++) A[i][j] =sc.nextInt();
            }

            long[][] dp = new long[n][m];
            // for(int i = 0;i <= size;i++){
            //     dp[i][0] = 1;
            //     dp[i][i] = 1;
            // } 
            dp[0][0] = A[0][0];
            
            for(int i =  0 ; i <n ;i++){
                for(int j = 0 ;j < m;j++){
                    long bottom = 0;
                    long right = 0;
                    if(i>0) right = dp[i-1][j];
                    if(j > 0) bottom = dp[i][j-1];
                    if(i ==0 && j ==0) continue;
                    dp[i][j] = Math.max(right,bottom) + A[i][j];

                }
            }
            System.out.println(dp[n-1][m-1]);
        }
    }
}