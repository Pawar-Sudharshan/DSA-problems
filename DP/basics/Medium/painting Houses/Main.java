import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc  = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] R = new int[n];
            int[] G= new int[n];
            int[] B = new int[n];
            for(int i = 0 ; i < n ;i++) R[i] = sc.nextInt();
            for(int i = 0 ; i < n ;i++) G[i] = sc.nextInt();
            for(int i = 0 ; i < n ;i++) B[i] = sc.nextInt();

            int dpR[] = new int[n+1];
            int dpG[] = new int[n+1];
            int dpB[] = new int[n+1];
            dpB[0] = 0;
            dpG[0] = 0;
            dpR[0] = 0;

            for(int i =1;i<=n;i++){
                dpR[i] = R[i-1] + Math.min(dpG[i-1] , dpB[i-1]);
                dpG[i] = G[i-1] + Math.min(dpR[i-1] , dpB[i-1]);
                dpB[i] = B[i-1] + Math.min(dpG[i-1] , dpR[i-1]);
            }

            int ans = Math.min(dpR[n],Math.min(dpG[n],dpB[n]));
            System.out.println(ans);
 

        }
    }
}