package day9;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            BST tree = new BST();
            int n = sc.nextInt();
            for(int i = 0 ; i < n ;i++) tree.insert(sc.nextInt());
            tree.order();
            // System.out.println();
            
        }
    }
}

class BST{
    Node root;
    static long  val ;
    public BST(){
        root =null;
    }
    public void insert(int x){
        root = insertHelper(root,x);
    }

    public Node insertHelper(Node root , int x){
        if(root == null) return new Node(x);
        else if(x < root.data) root.left =insertHelper(root.left , x);
        else if(x > root.data) root.right = insertHelper(root.right , x);
        return root;
    }

    public void order(){
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
             System.out.println();
            return;
        }
         queue.offer(root);
        while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0 ; i  < size ; i++){
                Node curr = queue.poll();
                System.out.print(curr.data+" ");
                // if(i < size -1) System.out.println();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
                }
                System.out.println();

        }

      
    }
   
}

class Node{
    int data;
    Node left , right;
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}