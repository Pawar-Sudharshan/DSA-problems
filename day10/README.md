LRU Cache
Design and implement an LRU (Least Recently Used) Cache data structure. Given a list of page numbers, insert them into a cache of size 
K
K, replacing the least recently used item on overflow.

Pages are inserted in the order given.

If the page already exists in the cache, move it to the most recent position.

If the cache is full and a new unique page is added, evict the least recently used page.

Each test case output shows the cache contents from least to most recently used.

Examples
Example 1:

text
Input:
3
5 3
3 8 2 8 1
8 5
4 7 3 10 7 8 5 3
10 5
6 5 6 2 3 14 2 1 10 10

Output:
2 8 1
10 7 8 5 3
3 14 2 1 10
Constraints
1
≤
T
≤
1000
1≤T≤1000 — Number of test cases

1
≤
N
,
K
≤
5000
1≤N,K≤5000 — Number of pages & cache size

1
≤
p
[
i
]
≤
100000
1≤p[i]≤100000 — Page values

Approach
Use a doubly-linked list to store cache entries in usage order.

Use a hashmap for O(1) checks for entry existence.

For each page:

If already in cache, move to most recent position.

If not, add to most recent and remove LRU if the cache is full.

After all insertions, print the cache from least to most recently used.

Java Solution
java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            LRUCache cache = new LRUCache(k);
            for(int i = 0 ; i < n ; i++) cache.insert(sc.nextInt());
            cache.display();
        }
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node lru; // Dummy head
    Node mru; // Tail
    int k;
    public LRUCache(int size){
        map = new HashMap<>();
        lru = new Node(-1);
        mru = lru;
        this.k = size;
    }
    public void insert(int x){
        if(k == 0) return;
        if(map.containsKey(x)){
            Node t = map.get(x);
            if(t != mru){
                if(t.next != null) t.next.prev = t.prev;
                if(t.prev != null) t.prev.next = t.next;
                mru.next = t;
                t.next = null;
                t.prev = mru;
                mru = t;
            }
        } else {
            Node p = new Node(x);
            map.put(x, p);
            mru.next = p;
            p.prev = mru;
            mru = p;
            if(map.size() > k){
                map.remove(lru.next.data);
                lru.next = lru.next.next;
                if(lru.next != null) lru.next.prev = lru;
            }
        }
    }
    public void display(){
        Node temp = lru.next;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next, prev;
    public Node(int data){
        this.data = data;
        next = prev = null;
    }
}
Dry Run
Testcase 1
Pages: 3 8 2 8 1   Cache Size: 3

Step	Operation	Cache (LRU → MRU)	Comments
1	Insert 3	3	Add 3
2	Insert 8	3 8	Add 8
3	Insert 2	3 8 2	Add 2
4	Insert 8	3 2 8	Move 8 to MRU
5	Insert 1	2 8 1	Remove 3, Add 1
text
Output:
2 8 1
Time Complexity
O(N) for each test case where 
N
N is the number of inserted pages.

Space Complexity
O(K) per test case (for the cache list and hashmap).