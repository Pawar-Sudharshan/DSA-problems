package day10;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc =new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            LRUCache cache = new LRUCache(k);
            for(int i = 0 ; i < n ;i++)cache.insert(sc.nextInt());
            cache.display();            
        }
    }
}
class LRUCache{
    Map<Integer , Node>  map ;
    Node lru ; 
    Node mru ;
    int k ;
    public LRUCache(int size){
        map =  new HashMap<>();
        lru = new Node(-1);
        mru = lru ; 
        this.k = size;
    }

    public void insert(int x){
        if(k == 0) return ;
        if(map.containsKey(x)){
            Node t = map.get(x);
            if(t != mru){
                if(t.next != null)
                    t.next.prev = t.prev;
                if(t.prev != null)
                    t.prev.next = t.next;
                mru.next = t;
                t.next = null;
                t.prev = mru;
                mru = t;
            }
        }else{
            Node p = new Node(x);
            map.put(x,p);
            mru.next = p;
            p.prev = mru;
            mru = p;
           if(map.size()>k)
           {
            map.remove(lru.next.data);
            lru.next = lru.next.next;
            lru.next.prev = lru;
           }
        }
    }

    public void display(){
        Node temp = lru.next;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp =temp.next;
        }
        System.out.println();
    }

}


class Node{
    int data;
    Node next;
    Node prev;
    public Node(int data){
        this.data = data;
        next = prev = null;
    }
}