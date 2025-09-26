import java.io.*;
import java.util.*;

public class Main {
    public static int[] findLeft(int []A){
        int n =A.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop();
            }
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public static int[] findRight(int[] A){
        int n = A.length;
        int ans[]=new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >=0 ;i--){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop();
            }
            if(stack.isEmpty())ans[i]=n;
            else ans[i]=stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int t =sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int[] A=new int[n];
            for(int i = 0 ; i < n;i++) A[i]=sc.nextInt();
            int[] left = findLeft(A);
            int[] right = findRight(A);
            long ans = 0;
            for(int i = 0 ; i < n ;i++){
                ans = Math.max(ans , (long)A[i]*(right[i] - left[i] -1));
            }
            System.out.println(ans);
        }
    }
}
