import java.io.*;
import java.util.*;

public class Main {
    static int top = -1;
  static  class  Stack{
         int size;
         int A[];
        
         public Stack(int size){
            this.size = size;
            A= new int[size];

         }

         public  void push(int x){
            if(top == size-1){
                System.out.println("Stack is full!");
                return;
            }
            A[++top] = x;
         }
         public  void pop(){
            if(top == -1) {
                System.out.println("Empty");
                return;
            }
           int val = A[top];
           top--;
           System.out.println(val);
         }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc= new Scanner(System.in);
        int t =sc.nextInt();
        Stack stack=new Stack(t);
        while(t-->0){
            String ch = sc.next();
            if(ch.equals("push")) {
                int x =sc.nextInt();
                stack.push(x);
            }else{
                stack.pop();
            }
        }
    }
}